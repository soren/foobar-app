package net.twonky.foobar.gotchas;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/*
 * https://stackoverflow.com/questions/65035/does-finally-always-execute-in-java
 */
public class FinallyWillAlwaysExecureTest {
    private int calc(int seed) {

        int x = seed;

        try {
            return ++x;
        } catch (Exception e) {
            // Ignore
        } finally {
            ++x;
        }
        return x;
    }
    
    @Test
    public void finallyWillModifyVariableBeforeItIsReturned() {
        assertEquals(2, new FinallyWillAlwaysExecureTest().calc(1));
    }
}
