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
}
