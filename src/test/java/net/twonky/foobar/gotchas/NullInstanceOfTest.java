package net.twonky.foobar.gotcha;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class NullInstanceOfTest {

    private static String s1;
    private static String s2 = "string";

    @Test
    public void nullIsNotAnInstanceOfString() {
        assertFalse(s1 instanceof String);
    }

    @Test
    public void stringIsAnInstanceOfString() {
        assertTrue(s2 instanceof String);
    }

}
