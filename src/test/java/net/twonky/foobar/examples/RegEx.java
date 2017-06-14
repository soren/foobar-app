package net.twonky.foobar.examples;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {
	private final Pattern pattern;
	private Matcher matcher;

	private RegEx(String regex) {
		pattern = Pattern.compile(regex);
	}

	public static RegEx build(String regex) {
		return new RegEx(regex);
	}

	public boolean m(String s) {
		matcher = pattern.matcher(s);
		return matcher.find();
	}

	public String group(String name) {
		return matcher.group(name);
	}
}
