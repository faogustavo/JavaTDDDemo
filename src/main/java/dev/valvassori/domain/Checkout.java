package dev.valvassori.domain;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

public class Checkout {

    private final Store store;
    private final Map<Product, Integer> products = new HashMap<>();
    private Voucher voucher = null;

    public Checkout(Store store) {
        this.store = store;
    }

    // TODO: Implement getQuantityCount
    public int getQuantityCount() {
        return products.values()
            .stream()
            .reduce(0, Integer::sum);
    }

    // TODO: Implement addProduct
    public void addItem(int productId, int quantity) {
        if (quantity <= 0) {
            throw new InvalidParameterException("Quantity should be greater then zero");
        }

        Product product = store.getProduct(productId);
        if (product == null) {
            throw new InvalidParameterException(
                String.format("Product with id %d was not found in the store", productId)
            );
        }

        int newQuantity = products.getOrDefault(product, 0) + quantity;
        if (newQuantity > product.getQuantity()) {
            throw new IllegalStateException(
                String.format(
                    "The store only has %d of this item in stock. You requested %d.",
                    product.getQuantity(),
                    quantity
                )
            );
        }

        products.put(product, newQuantity);
    }

    // TODO: Implement getSubtotal
    public double getSubtotal() {
        double subtotal = 0;

        for (Product product : products.keySet()) {
            subtotal += product.getPrice() * products.get(product);
        }

        return subtotal;
    }

    // TODO: Implement getDiscount
    public double getDiscount() {
        if (voucher == null) {
            return 0;
        } else {
            return voucher.calculateDiscountFor(getSubtotal());
        }
    }

    public void addVoucher(String code) {
        voucher = store.getVoucher(code);
    }

    // TODO: Implement getTotal
    public double getTotal() {
        return Math.max(getSubtotal() - getDiscount(), 0);
    }
}
