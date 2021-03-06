import java.util.Arrays;

/**
 * Methods for computing some common statistics,
 * such as average, variance, and correlation.
 * @author Hayato Kawai
 */
public class Statistics {

	/**
	 * Compute the arithmetic average of an array of numbers.
	 * @param x is array to compute average of.  Must not be null.
	 * @return the arithmetic average of values in x, or 0 if x is empty.
	 */
	public static double average(double[] x) {
		// Some fun: sum using a Stream instead of a loop.
		int len = x.length ;
		if( len == 0) return 0 ;
		double sum = Arrays.stream(x).sum();
		return sum/len;
	}
	
	/**
	 * Compute the variance of values in an array.
	 * Variance uses the formula sum(x[k]*x[k])/length(x) - average(x)^2.
	 * 
	 * @param x is the array of values. Must contain at least 1 element.
	 * @return the variance of x
	 * @throws IllegalArgumentException if x is empty
	 */
	public static double variance(double[] x) {
		int range = x.length;
		if(range == 0 ) throw new IllegalArgumentException ("Array must not be null") ;
		double mean = average(x);
		for(int i = 0 ; i < range ; i++) {
			x[i] = Math.pow((x[i] - mean ) , 2);
		}
		return average(x);
	}
	
	/**
	 * Compute the covariance between arrays x and y.
	 * The covariance is defined by
	 * 
	 * sum[ (x[k] - average(x)) * (y[k] - average(y)) ]/n
	 * where n is number of elements in the arrays.
	 * 
	 * But it is more efficient to compute using the equivalent formula:
	 * 
	 * sum( x[k]*y[k] )/n - average(x)*average(y)
	 * 
	 * Note that if x == y, this is the variance.
	 * 
	 * @param x is the first array of values.
	 * @param y is the second array of values
	 * @return the covariance between x and y
	 * @throws IllegalArgumentException if arrays are not same length or length is 0.
	 */
	public static double covariance(double[] x, double[] y) {
		int limitX = x.length;
		int limitY = y.length;
		if ( limitX == 0 || limitY == 0) throw new IllegalArgumentException("Array must not be null") ;
		if ( limitX != limitY ) throw new IllegalArgumentException("Both array should have same length") ;
		double [] cov = new double [limitX];
		double avgX = average(x) ;
		double avgY = average(y) ;
		for( int i = 0 ; i< limitX ; i++) {
			cov[i] = x[i]*y[i];
		}
		double sum = Arrays.stream(cov).sum();
		return sum/ limitX - (avgX*avgY);
	}
	
}
