
package com.mycompany.uts_kasirasuransi;
import java.sql.Date;

public class Klaim {
    private int id;
    private Polis polis;
    private String tanggal;
    private String status;

    // Constructor, Getter, dan Setter
    public Klaim(Polis polis, String tanggal, String status) {
        this.polis = polis;
        this.tanggal = tanggal;
        this.status = status;
    }
}