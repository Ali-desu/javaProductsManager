package org.example.gestionproduits.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Produit {
    private int id;
    private String nom;
    private String description;
    private double prix;
    private Commercial commercial;

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        return this.id == ((Produit)obj).id;
    }

    @Override
    public int hashCode() {
        return this.id;
    }
}
