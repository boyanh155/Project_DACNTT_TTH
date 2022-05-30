package com.k19.models;

import java.text.NumberFormat;

public class lineItemJPA {
    private product product;
    private int quantity;

    public lineItemJPA() {
    }
    public void setProduct(product product) {
        this.product = product;
    }
    public product getProduct() {
        return this.product;
    }
    public int getQuantity() {
        return this.quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        double total=quantity*product.getPrice();
        return total;
    }
    public String getpriceFormatTotal() {
        NumberFormat cformat = NumberFormat.getCurrencyInstance();
        return cformat.format(this.getTotal());
    }

}
