package dev.valvassori.domain;

import dev.valvassori.domain.factory.StoreFactory;
import org.junit.Assert;
import org.junit.Test;

public class StoreTest {

    private final Store subject = StoreFactory.testStore();

    @Test
    public void getProduct_withNonExistingId_returnsNull() {
        // When
        Product product = subject.getProduct(-1);

        // Then
        Assert.assertNull(product);
    }

    @Test
    public void getProduct_withExistingId_returnsIt() {
        // When
        Product product = subject.getProduct(3);

        // Then
        String expectedProductName = "Sweatpants";
        double expectedProductPrice = 30;

        Assert.assertNotNull(product);
        Assert.assertEquals(expectedProductName, product.getName());
        Assert.assertEquals(expectedProductPrice, product.getPrice(), 0.0001);
    }

    @Test
    public void getVoucher_withNonExistingCode_returnsNull() {
        // When
        Voucher voucher = subject.getVoucher("50off");

        // Then
        Assert.assertNull(voucher);
    }

    @Test
    public void getVoucher_withExistingCode_returnsIt() {
        // When
        Voucher voucher = subject.getVoucher("20off");

        // Then
        Voucher.Type expectedVoucherType = Voucher.Type.PERCENTAGE;
        double expectedVoucherAmount = 0.2;

        Assert.assertNotNull(voucher);
        Assert.assertEquals(expectedVoucherType, voucher.getType());
        Assert.assertEquals(expectedVoucherAmount, voucher.getAmount(), 0.0001);
    }
}