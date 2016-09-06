package net.twonky.foobar.tricks.collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

public class ListInitializationTest {

    private List<String> strings;
    private List<String> unmodifiable;
    private List<String> stringsPreJava8;
    private List<String> stringsPreJava7;

    @Before
    @SuppressWarnings("serial") // stringsPreJava7 double brace initialization
    public void setUp() {
        strings = Stream.of("s1", "s2", "s3", "s4").collect(Collectors.toList());
        unmodifiable = Collections.unmodifiableList(strings);
        stringsPreJava8 = Arrays.asList("s1", "s2", "s3", "s4");
        stringsPreJava7 = new ArrayList<String>() {
            {
                add("s1");
                add("s2");
                add("s3");
                add("s4");
            }
        };
    }

    static String expected = "s1s2s3s4";

    @Test
    public void unmodifiablesContainsExpectedList() {
        assertEquals(expected, unmodifiable.stream().collect(Collectors.joining()));
    }

    @Test
    public void unmodifiablesCannotBeModified() {
        try {
            unmodifiable.set(0, "s0");
            fail("It should not be possible to modify elements");
        } catch (UnsupportedOperationException e) {
            assertEquals(expected, unmodifiable.stream().collect(Collectors.joining()));
        }
        try {
            unmodifiable.add("s5");
            fail("It should not be possible to add elements");
        } catch (UnsupportedOperationException e) {
            assertEquals(4, unmodifiable.size());
        }
    }

    @Test
    public void stringsContainsExpectedList() {
        assertEquals(expected, strings.stream().collect(Collectors.joining()));
    }

    @Test
    public void stringsCanBeModified() {
        strings.set(0, "s0");
        assertEquals(4, strings.size());
        assertFalse(expected.equals(strings.stream().collect(Collectors.joining())));

        strings.add("s5");
        assertEquals(5, strings.size());
        assertEquals(5, unmodifiable.size());
    }

    @Test
    public void stringsPreJava8ContainsExpectedList() {
        assertEquals(expected, stringsPreJava8.stream().collect(Collectors.joining()));
    }

    @Test
    public void stringsPreJava7ContainsExpectedList() {
        assertEquals(expected, stringsPreJava7.stream().collect(Collectors.joining()));
    }

}
