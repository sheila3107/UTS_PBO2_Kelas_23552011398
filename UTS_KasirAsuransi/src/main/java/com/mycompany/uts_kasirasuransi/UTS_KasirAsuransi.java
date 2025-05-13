package com.mycompany.uts_kasirasuransi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class UTS_KasirAsuransi {
        public static void main(String[] args) {
        Connection conn = DatabaseConnection.getConnection();
        Scanner scanner = new Scanner(System.in);

        if (conn == null) {
            System.out.println("Koneksi ke database gagal!");
            return; // Keluar dari program jika koneksi gagal
        }
        System.out.println("Koneksi ke database berhasil!");

        // Menghapus data dari tabel polis dan nasabah
        clearDatabase(conn);

        // Loop untuk menambahkan nasabah dan polis
        while (true) {
            try {
                int nasabahId = addNasabah(scanner, conn);
                if (nasabahId != -1) {
                    int polisId = addPolis(scanner, conn, nasabahId);
                    if (polisId != -1) {
                        addKlaim(conn, polisId);
                    }
                }

                System.out.println("\nDaftar Nasabah dan Polis:");
                displayNasabahAndPolis(conn);

                System.out.print("Apakah Anda ingin menambahkan nasabah lain? (y/n): ");
                String choice = scanner.nextLine();
                if (!choice.equalsIgnoreCase("y")) {
                    break; // Keluar dari loop jika tidak ingin menambah lagi
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Menutup koneksi setelah selesai
        scanner.close();
        closeConnection(conn);
    }

    private static void clearDatabase(Connection conn) {
        try {
            String sqlPolisDelete = "DELETE FROM polis";
            PreparedStatement pstmtPolisDelete = conn.prepareStatement(sqlPolisDelete);
            pstmtPolisDelete.executeUpdate(); // Hapus data polis

            String sqlNasabahDelete = "DELETE FROM nasabah";
            PreparedStatement pstmtNasabahDelete = conn.prepareStatement(sqlNasabahDelete);
            pstmtNasabahDelete.executeUpdate(); // Hapus data nasabah

            System.out.println("Semua data di tabel polis dan nasabah telah dihapus.");
        } catch (SQLException e) {
            System.err.println("Gagal saat menghapus data: " + e.getMessage());
        }
    }

    private static int addNasabah(Scanner scanner, Connection conn) throws SQLException {
        System.out.print("Masukkan nama nasabah: ");
        String namaNasabah = scanner.nextLine();
        System.out.print("Masukkan umur nasabah: ");
        int umurNasabah = scanner.nextInt();
        scanner.nextLine(); // Mengkonsumsi newline

        String sqlNasabah = "INSERT INTO nasabah (nama, umur) VALUES (?, ?)";
        PreparedStatement pstmtNasabah = conn.prepareStatement(sqlNasabah, PreparedStatement.RETURN_GENERATED_KEYS);
        pstmtNasabah.setString(1, namaNasabah);
        pstmtNasabah.setInt(2, umurNasabah);
        pstmtNasabah.executeUpdate();
        System.out.println("Nasabah ditambahkan dengan sukses.");

        ResultSet generatedKeys = pstmtNasabah.getGeneratedKeys();
        if (generatedKeys.next()) {
            return generatedKeys.getInt(1);
        }
        return -1; // Indicate failure to retrieve ID
    }

    private static int addPolis(Scanner scanner, Connection conn, int nasabahId) throws SQLException {
        System.out.println("Pilih jenis polis:");
        System.out.println("1. Polis Asuransi Kesehatan");
        System.out.println("2. Polis Asuransi Pendidikan");
        System.out.println("3. Polis Asuransi Jiwa");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String jenisPolis = "";
        double premi = 0.0;

        switch (choice) {
            case 1:
                System.out.print("Masukkan nama jenis polis Asuransi Kesehatan: ");
                jenisPolis = scanner.nextLine();
                premi = 150.00; // Ganti sesuai kebutuhan
                break;
            case 2:
                System.out.print("Masukkan nama jenis polis Asuransi Pendidikan: ");
                jenisPolis = scanner.nextLine();
                premi = 200.00; // Ganti sesuai kebutuhan
                break;
            case 3:
                System.out.print("Masukkan nama jenis polis Asuransi Jiwa: ");
                jenisPolis = scanner.nextLine();
                premi = 250.00; // Ganti sesuai kebutuhan
                break;
            default:
                System.out.println("Pilihan tidak valid!");
                return -1;
        }

        String sqlPolis = "INSERT INTO polis (nasabah_id, jenis, premi) VALUES (?, ?, ?)";
        PreparedStatement pstmtPolis = conn.prepareStatement(sqlPolis, PreparedStatement.RETURN_GENERATED_KEYS);
        pstmtPolis.setInt(1, nasabahId);
        pstmtPolis.setString(2, jenisPolis);
        pstmtPolis.setDouble(3, premi);
        pstmtPolis.executeUpdate();
        System.out.println("Polis " + jenisPolis + " ditambahkan dengan sukses.");

        ResultSet generatedKeysPolis = pstmtPolis.getGeneratedKeys();
        if (generatedKeysPolis.next()) {
            return generatedKeysPolis.getInt(1);
        }
        return -1; // Indicate failure to retrieve ID
    }

    private static void addKlaim(Connection conn, int polisId) throws SQLException {
        String tanggalKlaim = LocalDate.now().toString(); // Tanggal saat ini
        String statusKlaim = "Berhasil"; // Status default

        String sqlKlaim = "INSERT INTO klaim (polis_id, tanggal, status) VALUES (?, ?, ?)";
        PreparedStatement pstmtKlaim = conn.prepareStatement(sqlKlaim);
        pstmtKlaim.setInt(1, polisId);
        pstmtKlaim.setString(2, tanggalKlaim);
        pstmtKlaim.setString(3, statusKlaim);
        pstmtKlaim.executeUpdate();
        System.out.println("Klaim berhasil ditambahkan dengan tanggal: " + tanggalKlaim + " dan status: " + statusKlaim);
    }

    private static void displayNasabahAndPolis(Connection conn) throws SQLException {
        System.out.println("\n===============================");
        System.out.println("     DAFTAR NASABAH DAN POLIS  ");
        System.out.println("===============================");

        String sqlSelectNasabah = "SELECT * FROM nasabah";
        PreparedStatement pstmtSelectNasabah = conn.prepareStatement(sqlSelectNasabah);
        ResultSet rsNasabah = pstmtSelectNasabah.executeQuery();

        while (rsNasabah.next()) {
            int nasabahId = rsNasabah.getInt("id");
            String namaNasabah = rsNasabah.getString("nama");
            int umurNasabah = rsNasabah.getInt("umur");

            System.out.println("Nasabah ID: " + nasabahId);
            System.out.println("Nama: " + namaNasabah);
            System.out.println("Umur: " + umurNasabah);
            System.out.println("Daftar Polis:");

            displayPolisByNasabahId(conn, nasabahId);
            System.out.println(); // Menambahkan baris kosong setelah setiap nasabah
        }
    }

    private static void displayPolisByNasabahId(Connection conn, int nasabahId) throws SQLException {
        String sqlSelectPolis = "SELECT * FROM polis WHERE nasabah_id = ?";
        PreparedStatement pstmtSelectPolis = conn.prepareStatement(sqlSelectPolis);
        pstmtSelectPolis.setInt(1, nasabahId);
        ResultSet rsPolis = pstmtSelectPolis.executeQuery();

        // Add title for the type of policy
        while (rsPolis.next()) {
            String jenisPolis = rsPolis.getString("jenis");
            System.out.println("### " + jenisPolis + " ###");
            
            int polisId = rsPolis.getInt("id");
            double premi = rsPolis.getDouble("premi");

            System.out.println("  - Polis ID: " + polisId);
            System.out.printf("    Premi: Rp%.2f\n", premi);
        }
    }

    private static void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close(); // Menutup koneksi setelah selesai
                System.out.println("Koneksi ke database ditutup.");
            }
        } catch (SQLException e) {
            System.err.println("Gagal saat menutup koneksi: " + e.getMessage());
        }
    }
}