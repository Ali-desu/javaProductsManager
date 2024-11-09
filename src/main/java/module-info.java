module org.example.gestionproduits {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires com.zaxxer.hikari;
    requires java.sql;


    opens org.example.gestionproduits to javafx.fxml;
    exports org.example.gestionproduits;
    exports org.example.gestionproduits.util;
    opens org.example.gestionproduits.util to javafx.fxml;
    exports org.example.gestionproduits.controllers;
    opens org.example.gestionproduits.controllers to javafx.fxml;
}