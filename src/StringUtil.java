/**
 * Some utility methods for Strings.
 * @author Pittayoot R.R.Ratanakul
 */
public class StringUtil {
	/**
	 * Find the index of a String (arg) in an array of Strings.
	 * @param arg is the string to search for
	 * @param array is an array of Strings to examine
	 * @return the index of first occurence of arg, or -1 if it is not in the array.
	 */
	public static int indexOf(String arg, String[] array) {
		int index = -1;
		int arraylen = array.length;
		for(int k=0; k<arraylen; k++) {
			if (array[k].equals(arg)) {
			index = k;
			break;}	
		}
		return index;
	}
}
