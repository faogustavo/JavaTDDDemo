package dev.valvassori.domain;

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
        products.put(
                store.getProduct(productId),
                quantity
        );
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
}
