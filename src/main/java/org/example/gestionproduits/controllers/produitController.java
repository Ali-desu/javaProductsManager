package org.example.gestionproduits.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.example.gestionproduits.dao.impl.JDBCCommercialDaoImpl;
import org.example.gestionproduits.dao.impl.JDBCProduitDaoImpl;
import org.example.gestionproduits.models.Commercial;
import org.example.gestionproduits.models.Produit;

import java.util.Set;

public class produitController {
    @FXML
    private TextField nameField;
    @FXML
    private TextField priceField;
    @FXML
    private TextArea descriptionArea;
    @FXML
    private ComboBox<Commercial> commercialComboBox;
    @FXML
    private Label status;

    @FXML
    private void initialize() {
        JDBCCommercialDaoImpl commercialDao = new JDBCCommercialDaoImpl();
        Set<Commercial> commercials = commercialDao.selectAll();

        // Convert Set to ObservableList and set it in the ComboBox
        ObservableList<Commercial> observableCommercials = FXCollections.observableArrayList(commercials);
        commercialComboBox.setItems(observableCommercials);
    }


    @FXML
    private void handleAddProduct() {
        // Retrieve text values from TextFields and TextArea
        String name = nameField.getText();
        String priceText = priceField.getText();
        String description = descriptionArea.getText();

        // Retrieve selected Commercial from ComboBox
        Commercial selectedCommercial = commercialComboBox.getValue();

        // Convert price to double if necessary
        double price;
        try {
            price = Double.parseDouble(priceText);
        } catch (NumberFormatException e) {
            // Handle invalid price input
            System.out.println("Invalid price format.");
            return;
        }

        // Ensure a Commercial is selected
        if (selectedCommercial == null) {
            System.out.println("Please select a commercial.");
            return;
        }

        Produit produit = new Produit();
        produit.setNom(name);
        produit.setDescription(description);
        produit.setPrix(price);
        produit.setCommercial(selectedCommercial);

        int res = new JDBCProduitDaoImpl().add(produit);
        if(res > 0){
            status.setText("product added successfully");
        }
        else{
            status.setText("product not added");
        }
    }

}
