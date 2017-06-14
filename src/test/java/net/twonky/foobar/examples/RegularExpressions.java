package net.twonky.foobar.examples;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class RegularExpressions {

	@Test
	public void basicMatching() {
		String s = "abcABCaabbccabc";

		assertFalse(s.matches("ABC"));
		assertTrue(s.matches("[a-c]+ABC[a-c]+"));
		assertTrue(s.matches(".*ABC.*"));

		Pattern p = Pattern.compile("ABC");

		assertFalse(p.matcher(s).matches());
		assertTrue(p.matcher(s).find());

		RegEx re = RegEx.build("ABC");
		assertTrue(re.m(s));
		assertTrue(RegEx.build("ABC").m(s));
		assertTrue(RegEx.build("^abc").m(s));
		assertFalse(RegEx.build("^abcabc").m(s));
	}

	@Test
	public void grouping() {
		String s = "2017-01-19";

		Pattern p = Pattern.compile("(\\d{4})-(\\d{2})-(\\d{2})");
		Matcher m = p.matcher(s);
		assertTrue(m.matches());
		assertEquals(s, m.group(0));
		assertEquals("2017", m.group(1));
		assertEquals("01", m.group(2));
		assertEquals("19", m.group(3));

		p = Pattern.compile("(?<year>\\d{4})-(?<month>\\d{2})-(?<day>\\d{2})");
		m = p.matcher(s);
		assertTrue(m.matches());
		assertEquals("2017", m.group("year"));
		assertEquals("01", m.group("month"));
		assertEquals("19", m.group("day"));

		RegEx re = RegEx.build("(?<year>\\d{4})-(?<month>\\d{2})-(?<day>\\d{2})");
		assertTrue(re.m(s));
		assertEquals("19", re.group("day"));
	}

}
