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

    // TODO: Implement getDiscount

    // TODO: Implement getTotal
}
