package dev.valvassori.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Store {

    private final int id;
    private final String name;
    private final List<Product> products;
    private final List<Voucher> vouchers;

    public Store(int id, String name) {
        this.id = id;
        this.name = name;
        this.products = new ArrayList<>();
        this.vouchers = new ArrayList<>();
    }

    // Important things
    public void addVoucher(Voucher voucher, int quantity) {
        for (int i = 0; i < quantity; i++) {
            vouchers.add(voucher);
        }
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public Product getProduct(int id) {
        for (Product product : products) {
            if (product.getId() == id)
                return product;
        }
        return null;
    }

    public Voucher getVoucher(String code) {
        for (Voucher voucher : getVouchers()) {
            if (voucher.getCode().equals(code))
                return voucher;
        }

        return null;
    }

    private List<Voucher> getVouchers() {
        return vouchers.stream().distinct().collect(Collectors.toList());
    }
    // End

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(String.format("- [Store] %s (#%d)\n", name, id));

        builder.append("\n  - Products:\n");
        for (Product product : products) {
            builder.append(String.format("\t %s\n", product.toString()));
        }

        builder.append("\n  - Accepted vouchers:\n");
        for (Voucher voucher : getVouchers()) {
            builder.append(String.format("\t %s\n", voucher.toString()));
        }

        return builder.toString();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Product> getProducts() {
        return products;
    }
}
