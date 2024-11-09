package org.example.gestionproduits.dao.impl;


import org.example.gestionproduits.util.Database;
import org.example.gestionproduits.dao.CommercialDao;
import org.example.gestionproduits.models.Commercial;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class JDBCCommercialDaoImpl implements CommercialDao {

    @Override
    public Set<Commercial> selectAll() {
        Set<Commercial> commercials = new HashSet<>();
        String query = "SELECT * FROM commercial";

        // Use try-with-resources to automatically close resources
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Commercial commercial = new Commercial();

                commercial.setMatricule(rs.getString("matricule"));
                commercial.setNom(rs.getString("nom"));
                commercial.setPrenom(rs.getString("prenom"));

                commercials.add(commercial);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching commercials", e);
        }

        return commercials;
    }

    @Override
    public void delete(String matricule) {
        String query = "DELETE FROM commercial WHERE matricule = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, matricule);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error deleting commercial with matricule: " + matricule, e);
        }
    }

}
