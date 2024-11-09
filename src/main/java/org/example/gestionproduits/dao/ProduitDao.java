package org.example.gestionproduits.dao;

import org.example.gestionproduits.models.Produit;

public interface ProduitDao {
    int add(Produit produit);
    int update(Produit produit);
}
