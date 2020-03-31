package com.aor.refactoring.example1;

public class OrderLine {
    private Product product;
    private int quantity;

    public OrderLine(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getTotal() {
        return product.getPrice() * (double)quantity;
    }

    public String toStr() {
        StringBuffer printBuffer = new StringBuffer();
        printBuffer.append(product.getName() + "(x" + quantity + "): " + getTotal() + "\n");
        return printBuffer.toString();
    }
}
