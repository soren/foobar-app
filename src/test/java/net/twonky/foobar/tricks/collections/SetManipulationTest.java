package net.twonky.foobar.tricks.collections;

import static org.junit.Assert.assertArrayEquals;

import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class SetManipulationTest {

	private static final String[] VALUES = { "one", "two", "three", "four" };

	private Set<String> set12;
	private Set<String> set23;
	private Set<String> set1234;

	@Before
	public void setUp() {
		set12 = buildLinkedHashSet(1,2);
		set23 = buildLinkedHashSet(2,3);
		set1234 = buildLinkedHashSet(1,2,3,4);
	}

	@Test
	public void addAll() {
		set12.addAll(set23);

		String[] expectetValues = { VALUES[0], VALUES[1], VALUES[2]};
		assertArrayEquals(expectetValues, set12.toArray());
	}

	@Test
	public void removeAll() {
		set1234.removeAll(set23);

		String[] expectetValues = { VALUES[0], VALUES[3] };
		assertArrayEquals(expectetValues, set1234.toArray());
	}

	private Set<String> buildLinkedHashSet(int... is) {
		Set<String> set = new LinkedHashSet<String>();
		for (int i : is) {
			set.add(VALUES[i-1]);
		}
		return set;
	}

}
