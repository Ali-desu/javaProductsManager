package org.example.gestionproduits.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Commercial {
    private String matricule;
    private String nom;
    private String prenom;
    private Set<Produit> produits;

    public Commercial(Commercial commercial) {
        this.matricule = commercial.getMatricule();
        this.nom = commercial.getNom();
        this.prenom = commercial.getPrenom();
        this.produits = commercial.getProduits();
    }

    @Override
    public String toString() {
        return this.matricule;
    }
}
