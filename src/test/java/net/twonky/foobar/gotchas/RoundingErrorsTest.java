package net.twonky.foobar.gotchas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class RoundingErrorsTest {

	@Test
	public void roundingErrors() {
		assertNotEquals(0, 0.1 + 0.2 - 0.3);
	}

	@Test
	public void rationalCalculations() {
		assertEquals(new Rational(0, 1), new Rational(1, 10).add(new Rational(1, 5)).sub(new Rational(3, 10)));
	}

	/**
	 * Calculate Greatest Common Divisor using Euclid's algorithm
	 *
	 * <pre>
	 * gcd(a,0) = a
	 * gcd(a,b) = gcd(b, a mod b)
	 * </pre>
	 */
	private static int greatestCommonDivisor(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return greatestCommonDivisor(b, a % b);
		}
	}

	class Rational {
		private int numerator;
		private int denominator;

		public Rational(int numerator, int denominator) {
			int gcd = greatestCommonDivisor(numerator, denominator);
			this.numerator = numerator / gcd;
			this.denominator = denominator / gcd;
		}

		/**
		 * Addition using
		 *
		 * <pre>
		 *  a     c    ad + bc
		 * --- + --- = -------
		 *  b     d      bd
		 * </pre>
		 */
		public Rational add(Rational that) {
			int numerator = (this.numerator * that.getDenominator()) + (this.denominator * that.getNumerator());
			int denominator = this.denominator * that.getDenominator();
			return new Rational(numerator, denominator);
		}

		/**
		 * Subtraction using
		 *
		 * <pre>
		 *  a     c    ad - bc
		 * --- - --- = -------
		 *  b     d      bd
		 * </pre>
		 */
		public Rational sub(Rational that) {
			int numerator = (this.numerator * that.getDenominator()) - (this.denominator * that.getNumerator());
			int denominator = this.denominator * that.getDenominator();
			return new Rational(numerator, denominator);
		}

		public int getNumerator() {
			return numerator;
		}

		public int getDenominator() {
			return denominator;
		}

		@Override
		public boolean equals(Object obj) {
			Rational that = (Rational) obj;
			return this.denominator == that.getDenominator() && this.numerator == that.getNumerator();
		}

	}
}
