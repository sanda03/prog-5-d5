package org.example;

public class Coffe {
    private final String name;
    private final double price;
    private int quantity;

    public Coffe(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return quantity > 0;
    }

    public void decrementQuantity() {
        if (isAvailable()) {
            quantity--;
        }
    }

    public int getQuantity() {
        return quantity;
    }
}
