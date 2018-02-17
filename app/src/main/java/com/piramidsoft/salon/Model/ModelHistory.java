package com.piramidsoft.salon.Model;

/**
 * Created by Ayo Maju on 17/02/2018.
 * Updated by Muhammad Iqbal on 17/02/2018.
 */

public class ModelHistory {
    private String Waktu,Jumlah,Keterangan;

    public ModelHistory() {
    }

    public ModelHistory(String waktu, String jumlah, String keterangan) {
        Waktu = waktu;
        Jumlah = jumlah;
        Keterangan = keterangan;
    }

    public String getWaktu() {
        return Waktu;
    }

    public void setWaktu(String waktu) {
        Waktu = waktu;
    }

    public String getJumlah() {
        return Jumlah;
    }

    public void setJumlah(String jumlah) {
        Jumlah = jumlah;
    }

    public String getKeterangan() {
        return Keterangan;
    }

    public void setKeterangan(String keterangan) {
        Keterangan = keterangan;
    }
}
