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
}
