package com.example.tanquanghuy_baitaplon;

public class Item {
    private String Title;
    private String Description;
    private int imag;

    public Item() {
    }

    public Item(String title, String description, int imag) {
        Title = title;
        Description = description;
        this.imag = imag;
    }

    public String Title() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String Description() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int imag() {
        return imag;
    }

    public void setImag(int imag) {
        this.imag = imag;
    }
}
