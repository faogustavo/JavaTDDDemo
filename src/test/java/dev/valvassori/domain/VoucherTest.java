package dev.valvassori.domain;

import org.junit.Test;

import org.junit.Assert;

public class VoucherTest {

    @Test
    public void calculateDiscountFor_withFixedPrice_returnsIt() {
        double result = new Voucher(1, "test", Voucher.Type.VALUE, 3.0)
                .calculateDiscountFor(10);

        Assert.assertEquals(3.0, result, 0.0001);
    }

    @Test
    public void calculateDiscountFor_withPercentage_returnsIt() {
        double result = new Voucher(1, "test", Voucher.Type.PERCENTAGE, 0.15)
                .calculateDiscountFor(10);

        Assert.assertEquals(1.5, result, 0.0001);
    }
}