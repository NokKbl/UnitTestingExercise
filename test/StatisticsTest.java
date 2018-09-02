import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import jdk.nashorn.internal.ir.ThrowNode;
/**
 * JUnit test for Statistics's class
 * @author Hayato Kawai
 *
 */
public class StatisticsTest {
	/** A small tolerance for floating point round-off (precision) error. */
	static final double TOL = 1.0E-6;
	
	@Test
	public void testAverageTinyArray() {
		double[] x = { 123.01 };
		assertEquals( x[0], Statistics.average(x), TOL);
		double[] y = { 123.01, 123.02 };
		assertEquals( 123.015, Statistics.average(y), TOL);
	}
	
	@Test
	public void testAverageMixedValues() {
		double[] x = new double[99];
		java.util.Arrays.fill(x, 12.5);
		assertEquals( 12.5, Statistics.average(x), TOL);
		// many values spaced around a known mean
		double avg = 1.125;
		int n = x.length;
		java.util.Arrays.fill(x, avg);
		for(int k=0; k<=n/2; k++) {
			x[k] -= 0.5*k;
			x[n-k-1] += 0.5*k;
		}
		assertEquals( avg, Statistics.average(x), TOL);
	}
	
	@Test
	public void testVariance() {
		double[] x = { 27 , 35.5 , 1 , 31 };
		double[] y = { 1, 2, 3, 5 };
		assertEquals( 179.671875, Statistics.variance(x), TOL);
		assertEquals( 2.1875 , Statistics.variance(y), TOL);
	}
	
	@Test
	public void testCovariance() {
		double[] x = { 5, 20, 40, 80, 100 };
		double[] y = { 10, 24, 33, 54, 10 };
		assertEquals( 150.2, Statistics.covariance(x,y), TOL);
		
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testVarianceNull () {
		double [] x = {} ;
		Statistics.variance(x);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testCovarianceNull () {
		double [] x = {} ;
		double [] y = { 1 , 2 ,3 } ;
		Statistics.covariance(x, y);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testCovarianNotSameLength () {
		double [] x = { 1, 2 } ;
		double [] y = { 1, 2 ,3 } ;
		Statistics.covariance(x, y);
	}

}
