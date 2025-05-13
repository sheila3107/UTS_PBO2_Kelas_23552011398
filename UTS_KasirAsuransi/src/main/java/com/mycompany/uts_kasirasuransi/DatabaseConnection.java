package com.mycompany.uts_kasirasuransi;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public static Connection getConnection() {
        try {
            // Pastikan tidak ada spasi di URL
            String url = "jdbc:mysql://localhost:3306/uts_kasirasuransi"; // Ganti dengan URL database kamu
            String user = "root"; // Ganti dengan username kamu
            String password = ""; // Ganti dengan password kamu
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.err.println("Koneksi ke database gagal: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}