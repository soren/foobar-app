package net.twonky.foobar.gotchas;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TernaryOperatorTest {

	private String createMessage(boolean condition) {
		return (condition ? "True" : "False") + " condition";
	}

	@Test
	public void trueCondition() {
		assertEquals("True condition", createMessage(true));
	}

	@Test
	public void falseCondition() {
		assertEquals("False condition", createMessage(false));
	}

}
