package dev.valvassori.domain.factory;

import dev.valvassori.domain.Product;
import dev.valvassori.domain.Store;
import dev.valvassori.domain.Voucher;

public class StoreFactory {

    public static Store testStore() {
        Store store = new Store(1, "Gustavo's Store");

        store.addProduct(new Product(1, "T-Shirt", 24.9, 5));
        store.addProduct(new Product(2, "Hoodie", 44.95, 3));
        store.addProduct(new Product(3, "Sweatpants", 30, 7));

        store.addVoucher(new Voucher(1, "30dol", Voucher.Type.VALUE, 30), 5);
        store.addVoucher(new Voucher(2, "20off", Voucher.Type.PERCENTAGE, 0.20), 5);

        return store;
    }
}
