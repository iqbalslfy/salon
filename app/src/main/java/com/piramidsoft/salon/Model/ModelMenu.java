package com.piramidsoft.salon.Model;

/**
 * Created by Ayo Maju on 15/02/2018.
 * Updated by Muhammad Iqbal on 15/02/2018.
 */

public class ModelMenu {
    private int Img;
    private String Title;

    public ModelMenu() {
    }

    public ModelMenu(int img, String title) {
        Img = img;
        Title = title;
    }

    public int getImg() {
        return Img;
    }

    public void setImg(int img) {
        Img = img;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
