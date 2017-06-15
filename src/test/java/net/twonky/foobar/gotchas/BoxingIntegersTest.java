package net.twonky.foobar.gotchas;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/*
 * From http://docs.oracle.com/javase/specs/jls/se7/html/jls-5.html#jls-5.1.7
 *
 * "If the value p being boxed is true, false, a byte, or a char in the range \u0000 to \u007f,
 * or an int or short number between -128 and 127 (inclusive), then let r1 and r2 be the results
 * of any two boxing conversions of p. It is always the case that r1 == r2." 
 *
 */
public class BoxingIntegersTest {
		Integer a = 42;
		Integer b = 42;
		Integer c = 666;
		Integer d = 666;

    @Test
    public void smallIntegersAreBoxedInsideSharedObjects() {
        assertTrue(a == b);
    }

    @Test
    public void largerIntegersAreBoxedInsideNewObjects() {
        assertFalse(c == d);
    }
}
