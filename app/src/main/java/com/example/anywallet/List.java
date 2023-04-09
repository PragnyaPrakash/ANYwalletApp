package com.example.anywallet;

public class List {
    int Image;
    String amount;
    String sign;

    public List(int image, String amount, String sign) {
        Image = image;
        this.amount = amount;
        this.sign = sign;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
