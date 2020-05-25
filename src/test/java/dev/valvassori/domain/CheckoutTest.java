package dev.valvassori.domain;

import dev.valvassori.domain.factory.StoreFactory;
import org.junit.Before;

public class CheckoutTest {

    private Checkout subject;

    @Before
    public void setUp() {
        subject = new Checkout(StoreFactory.testStore());
    }
}
