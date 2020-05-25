package dev.valvassori.domain;

import dev.valvassori.domain.factory.StoreFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CheckoutTest {

    private Checkout subject;

    @Before
    public void setUp() {
        subject = new Checkout(StoreFactory.testStore());
    }

    @Test
    public void getQuantityCount_withoutItems_returnZero() {
        int result = subject.getQuantityCount();

        Assert.assertEquals(0, result);
    }

    @Test
    public void getQuantityCount_withAddedItem_returnsItsQuantity() {
        subject.addItem(1, 3);

        int result = subject.getQuantityCount();

        Assert.assertEquals(3, result);
    }

    @Test
    public void getQuantityCount_withAddedDifferentItem_returnsItsQuantity() {
        subject.addItem(1, 2);
        subject.addItem(2, 1);

        int result = subject.getQuantityCount();

        Assert.assertEquals(3, result);
    }

    @Test
    public void getSubtotal_withoutItems_returnZero() {
        double result = subject.getSubtotal();

        Assert.assertEquals(0, result, 0.00001);
    }

    @Test
    public void getSubtotal_withOneItem_returnsItsPrice() {
        subject.addItem(1, 1);

        double result = subject.getSubtotal();

        Assert.assertEquals(24.9, result, 0.00001);
    }

    @Test
    public void getSubtotal_withItems_returnsItsPrice() {
        subject.addItem(1, 1);
        subject.addItem(2, 1);

        double result = subject.getSubtotal();

        Assert.assertEquals(69.85, result, 0.00001);
    }

    @Test
    public void getSubtotal_withOneItemWithMoreUnits_returnsItsPrice() {
        subject.addItem(1, 3);

        double result = subject.getSubtotal();

        Assert.assertEquals(74.7, result, 0.00001);
    }

    @Test
    public void getSubtotal_withManyOfSameItem_returnsItsPrice() {
        subject.addItem(1, 3);
        subject.addItem(2, 2);

        double result = subject.getSubtotal();

        Assert.assertEquals(164.6, result, 0.00001);
    }

    @Test
    public void getDiscount_withoutVoucher_returnsZero() {
        double result = subject.getDiscount();

        Assert.assertEquals(0, result, 0.00001);
    }

    @Test
    public void getDiscount_withVoucher_returnsItsDiscount() {
        subject.addItem(1, 3);
        subject.addVoucher("20off"); // 74.7 * 0.2 = 14.94

        double result = subject.getDiscount();

        Assert.assertEquals(14.94, result, 0.00001);
    }
}
