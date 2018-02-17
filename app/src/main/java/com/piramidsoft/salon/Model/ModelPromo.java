package com.piramidsoft.salon.Model;

/**
 * Created by Ayo Maju on 17/02/2018.
 * Updated by Muhammad Iqbal on 17/02/2018.
 */

public class ModelPromo {
    private int Image;
    private String Title,Angka,Tanggal;

    public ModelPromo() {
    }

    public ModelPromo(int image, String title, String angka, String tanggal) {
        Image = image;
        Title = title;
        Angka = angka;
        Tanggal = tanggal;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAngka() {
        return Angka;
    }

    public void setAngka(String angka) {
        Angka = angka;
    }

    public String getTanggal() {
        return Tanggal;
    }

    public void setTanggal(String tanggal) {
        Tanggal = tanggal;
    }
}
