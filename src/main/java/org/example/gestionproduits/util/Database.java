package org.example.gestionproduits.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Database {
    private static final HikariDataSource dataSource;

    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:4306/javaTd");
        config.setUsername("root");
        config.setPassword("");
        config.setMaximumPoolSize(10); // Set max pool size

        // Wrapping the initialization in a try-catch block to catch any errors during setup
        try {
            dataSource = new HikariDataSource(config);
            System.out.println("HikariDataSource initialized successfully.");
        } catch (Exception e) {
            // Log the exception for debugging purposes
            System.err.println("Error initializing HikariDataSource: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Failed to initialize HikariDataSource", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            // Log the exception to understand why the connection failed
            System.err.println("Error establishing connection: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    public static void closeDataSource() {
        if (dataSource != null && !dataSource.isClosed()) {
            dataSource.close();
            System.out.println("DataSource closed successfully.");
        }
    }
}
