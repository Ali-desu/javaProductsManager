package org.example.gestionproduits.dao;

import org.example.gestionproduits.models.Commercial;
import org.example.gestionproduits.models.Produit;

import java.util.Set;

public interface CommercialDao {
    Set<Commercial> selectAll();
    void delete(String matricule);
}
