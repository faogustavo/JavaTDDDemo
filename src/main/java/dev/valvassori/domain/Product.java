package dev.valvassori.domain;

import java.util.Objects;

public class Product {

    private final int id;
    private final String name;
    private final double price;
    private int quantity;

    public Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("- [Product] %d x %s for $ %.2f (#%d)", quantity, name, price, id);
    }

    @Override
    public boolean equals(Object other) {
        if (other == null || getClass() != other.getClass()) return false;
        Product product = (Product) other;
        return id == product.id && name.equals(product.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, quantity);
    }

    public int getId() {
        return id;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
