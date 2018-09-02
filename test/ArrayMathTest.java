import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

/**
 * Test methods in the ArrayMath class.
 * @author Kunyaruk Katebunlu
 */
public class ArrayMathTest {
	/** A small tolerance for floating point round-off (precision) error. */
	static final double TOL = 1.0E-6;

	@Test
	public void testDotProductTinyVectors() {
		// vector of length one
		double[] x = {5.2};
		double[] y = {-7.5};
		double expected = x[0]*y[0];
		assertEquals( expected, ArrayMath.dotProduct(x, y), TOL);
		assertEquals( expected, ArrayMath.dotProduct(y, x), TOL);
		
		// vector of size 0?
		x = new double[] { };
		y = new double[] { };
		assertEquals( 0.0, ArrayMath.dotProduct(x, y), TOL);
	}
	
	@Test
	public void testDotProductLargeVectors() {
		// vector size 2
		double[] x = new double[] {12.4, 3};
		double[] y = new double[] {4, 6};
		double expected = 67.6;
		assertEquals( expected, ArrayMath.dotProduct(x, y), TOL);
		assertEquals( expected, ArrayMath.dotProduct(y, x), TOL);
		
		x = new double[] {32, -8};
		y = new double[] {-3.4, 0};
		expected = -108.8;
		assertEquals( expected, ArrayMath.dotProduct(x, y), TOL);
		assertEquals( expected, ArrayMath.dotProduct(y, x), TOL);
		
		x = new double[] {1, Double.MIN_VALUE};
		y = new double[] {Double.MAX_VALUE, 1};
		expected = Double.MAX_VALUE - Double.MIN_VALUE;
		assertEquals( expected, ArrayMath.dotProduct(x, y), TOL);
		assertEquals( expected, ArrayMath.dotProduct(y, x), TOL);
		
		// vector size 3
		x = new double[] {12, 14.5, 56.3};
		y = new double[] {3, 0, 2.74};
		expected = 190.262;
		assertEquals( expected, ArrayMath.dotProduct(x, y), TOL);
		assertEquals( expected, ArrayMath.dotProduct(y, x), TOL);
		
		x = new double[] {-21, 12.7, 54.9};
		y = new double[] {2, 8, -2.74};
		expected = -90.826;
		assertEquals( expected, ArrayMath.dotProduct(x, y), TOL);
		assertEquals( expected, ArrayMath.dotProduct(y, x), TOL);
	}

	@Test
	public void testDotProductHugeVectors() {
		int len = 1_000_000;
		double[] x = new double[len];
		double[] y = new double[len];
		Random rand = new Random();
		double product = 0.0;
		for(int k=0; k<len; k++) {
			// to avoid overflowing the product using floats for elements
			double xk = (double) rand.nextFloat();
			double yk = (double) rand.nextFloat();
			x[k] = xk;
			y[k] = yk;
			product += xk*yk;
		}
		assertEquals( product, ArrayMath.dotProduct(x, y), TOL);
		assertEquals( product, ArrayMath.dotProduct(y, x), TOL);
	}

	/** 
	 * This test should throw an exception,
	 * but not after you change the spec for dotProduct!
	 */
	@Test(expected=java.lang.IllegalArgumentException.class)
	public void testDotProductLengthsNotSame() {
		double[] x = new double[] {1, 3, 5, 7, 9};
		double[] y = new double[] {-2, 0.5, 4};
		assertEquals( 19.5, ArrayMath.dotProduct(x, y), TOL);
		assertEquals( 19.5, ArrayMath.dotProduct(y, x), TOL);
	}

}
