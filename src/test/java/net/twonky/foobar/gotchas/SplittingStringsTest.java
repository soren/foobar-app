package net.twonky.foobar.gotchas;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/*
 * From http://docs.oracle.com/javase/7/docs/api/java/lang/String.html#split%28java.lang.String%29
 *
 * This method works as if by invoking the two-argument split method with the given expression and a
 * limit argument of zero. Trailing empty strings are therefore not included in the resulting array.
 *
 *
 * And http://docs.oracle.com/javase/7/docs/api/java/lang/String.html#split%28java.lang.String,%20int%29
 *
 * The limit parameter controls the number of times the pattern is applied and therefore affects the
 * length of the resulting array. If the limit n is greater than zero then the pattern will be applied
 * at most n - 1 times, the array's length will be no greater than n, and the array's last entry will
 * contain all input beyond the last matched delimiter. If n is non-positive then the pattern will be 
 * applied as many times as possible and the array can have any length. If n is zero then the pattern
 * will be applied as many times as possible, the array can have any length, and trailing empty strings
 * will be discarded. 
 *
 *
 * How to include trailing empty strings: System.out.println(list1.split(",",-1).length);
 */
public class SplittingStringsTest {
    private static String list1 = "a,b,c,d,,,";
	private static String list2 = ",,,d,e,f,g";
	
	@Test
	public void splitIgnoresEmptyTrailingFields() {
	    assertEquals(4, list1.split(",").length);
	}

    @Test
	public void splitDoesNotIgnoreEmptyLeadningFields() {
	    assertEquals(7, list2.split(",").length);
	}

    @Test
	public void splitWithLimitParameterOfMinusOneDoesNotIgnoreEmptyTrailingFields() {
	    assertEquals(7, list1.split(",",-1).length);
	}

}
