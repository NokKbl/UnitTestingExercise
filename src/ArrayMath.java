/**
 * ArrayMath class for computing some linear algebra methods,
 * such as dot product of two vectors.
 * 
 * @author Jim
 * @author Kunyaruk Katebunlu
 */
public class ArrayMath {

	/**
	 * Compute dot product of two vectors.
	 * The vectors must have the same length.
	 * 
	 * @param x first vector to multiply
	 * @param y second vector to multiply
	 * @return dot-product of x and y
	 * @throws IllegalArgumentException if x and y are not arrays of the same size
	 */
	public static double dotProduct(double[] x, double[] y) {
		int sizeX = x.length;
		int sizeY = y.length;
		double product = 0.0;
		
		if (sizeX != sizeY) throw new IllegalArgumentException("Vector lengths must be same");
		
		for (int k = 0; k < sizeX; k++) {
			product += x[k]*y[k];
		}
		
		return product;
	}
	
}
