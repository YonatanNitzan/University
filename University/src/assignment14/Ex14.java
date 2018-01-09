package assignment14;

import java.util.Arrays;

public class Ex14 {

	/**
	 * Counts the amount of time a given number appears in a given array of
	 * integers. <br>
	 * <br>
	 * Runtime complexity - O(log(n)) <br>
	 * Space complexity - O(n)
	 * 
	 * @param a
	 *            - an organized array of integers
	 * @param x
	 *            - an integer to be counted
	 * @return Returns the number of times {@code x} appears in array {@code a}.
	 */
	public static int count(int[] a, int x) {
		int mid;
		int low = 0, high = a.length - 1;
		int count;

		// Returns zero in the case of an empty array
		if (a.length == 0)
			return 0;

		// Returns values in the case of a single space array
		if (a.length == 1) {
			if (a[0] == x)
				return 1;
			else
				return 0;
		}

		// Finds the index of the first instance of x in the array
		while (low != high) {
			mid = (low + high) / 2;

			if (a[mid] >= x)
				high = mid;
			else
				low = mid + 1;
		}

		// Starting the count
		count = low;

		// Initializing variables for second phase
		low = 0;
		high = a.length - 1;

		// Finds the index of the last instance of x in the array
		while (low != high) {
			mid = (low + high) / 2;

			if (a[mid] <= x)
				low = mid;
			else
				high = mid - 1;

			// Balance edge condition
			if (low + 1 == high)
				high--;
		}

		// Calculates how many instances of x are in the array
		count = (high - count) + 1;

		return count;
	}

	public static int alternating(String s) {
		return 0;
	}

	public static boolean isWay(int[] a) {
		int p = 0;
		if (a[0] < 0)
			p = -a[0];
		
		if (p == a.length - 1)
			return true;
		
		if (a[p] == -1)
			return false;
		
		int m = a[p];
		a[p] = -1;
		
		if (p + m < a.length - 1) {
			a[0] = -(p + m);
			if (isWay(a))
				return true;
		}
		
		if (p - m > 0) {
			a[0] = -(p - m);
			if (isWay(a))
				return true;
		}
		
		return false;
	}
}