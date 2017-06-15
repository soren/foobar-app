package net.twonky.foobar.examples;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExTest {
	private final Pattern pattern;
	private Matcher matcher;

	private RegExTest(String regex) {
		pattern = Pattern.compile(regex);
	}

	public static RegExTest build(String regex) {
		return new RegExTest(regex);
	}

	public boolean m(String s) {
		matcher = pattern.matcher(s);
		return matcher.find();
	}

	public String group(String name) {
		return matcher.group(name);
	}
}
