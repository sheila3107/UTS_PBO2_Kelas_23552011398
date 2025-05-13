package com.mycompany.uts_kasirasuransi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Nasabah {
        private int id;
    private String nama;
    private int umur;

    public Nasabah(String nama, int umur) {
        this.nama = nama;
        this.umur = umur;
    }

    public String getNama() {
        return nama;
    }

    public int getId() {
        return id; // Anda bisa menambahkan logika untuk mengatur ID
    }

    public int getUmur() {
        return umur;
    }
}