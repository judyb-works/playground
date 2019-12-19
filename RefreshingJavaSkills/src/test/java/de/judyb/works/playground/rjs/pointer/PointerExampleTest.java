package de.judyb.works.playground.rjs.pointer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PointerExampleTest {

    private PointerExample po1;
    private PointerExample po2;

    @Before
    public void setUp() {
        po1 = new PointerExample(1);
        po2 = new PointerExample(2);
    }

    @After
    public void tearDown() {
        po1 = null;
        po2 = null;
    }

    @Test
    public void shouldPointOnDifferentObjects() {
        assertEquals(1, po1.getValue());
        assertEquals(2, po2.getValue());
    }

    @Test
    public void shouldSharePointer() {
        // pointer sharing (o1 points to o2)
        po1 = po2;

        assertEquals(2, po1.getValue());
        assertEquals(2, po2.getValue());
    }

    @Test
    public void shouldInfectSharedPointer1() {
        // pointer sharing (o1 and o2 point to same object)
        po1 = po2;
        // change on first pointer infects second pointer, they are pointing to the same object
        po1.setValue(3);

        assertEquals(3, po1.getValue());
        assertEquals(3, po2.getValue());
    }

    @Test
    public void shouldInfectSharedPointer2() {
        // pointer sharing (o1 and o2 point to same object)
        po1 = po2;
        // change on first pointer infects second pointer, they are pointing to the same object
        po2.setValue(3);

        assertEquals(3, po1.getValue());
        assertEquals(3, po2.getValue());
    }
}
