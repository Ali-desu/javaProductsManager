package org.example.gestionproduits.dao.impl;

import org.example.gestionproduits.util.Database;
import org.example.gestionproduits.dao.ProduitDao;
import org.example.gestionproduits.models.Produit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCProduitDaoImpl implements ProduitDao {

    @Override
    public int add(Produit produit) {
        String sql = "INSERT INTO produit (nom, description, prix,commercial_matricule) VALUES (?, ?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, produit.getNom());
            ps.setString(2, produit.getDescription());
            ps.setDouble(3, produit.getPrix());
            ps.setString(4,produit.getCommercial().getMatricule());

            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(Produit produit) {
        // Implement your update logic similarly
        return 0;
    }
}
