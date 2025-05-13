package com.mycompany.uts_kasirasuransi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Polis {
 private int id;
    private int nasabahId;
    private double premi;

    public Polis(int id, int nasabahId, double premi) {
        this.id = id;
        this.nasabahId = nasabahId;
        this.premi = premi;
    }

    public double getPremi() {
        return premi;
    }

    public int getNasabahId() {
        return nasabahId;
    }

    public int getId() {
        return id;
    }

    public String getJenis() {
        return "Umum"; // Default, bisa di-override
    }
}