package assignment14;

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

	private static final char ZERO = '0';

	/**
	 * Calculates the minimum number of switches to be made for a string of bits
	 * with n ones and n zeros to be of alternating order.
	 * 
	 * <br>
	 * <br>
	 * Runtime complexity - O(n) <br>
	 * Space complexity - O(1)
	 * 
	 * @param s
	 *            - String of bits with an equal number of ones and zeros
	 * @return Returns the minimum number of switches.
	 */
	public static int alternating(String s) {
		int count = 0;

		// Checks how many bits are in incorrect placement according to 0101 order
		for (int i = 0; i < s.length(); i += 2) {
			if (s.charAt(i) == ZERO)
				count++;
		}

		// If the count is larger then the worst case
		if (count > (s.length() / 2))
			return (s.length() / 2 - count);

		return count;
	}

	/**
	 * Checks if in a given array of natural numbers, there's a course from the
	 * first index to the last using the value of the index as the number of moves.
	 * 
	 * @param a
	 *            - array
	 * @return Returns whether there's a possible course from the first index to the
	 *         last.
	 */
	public static boolean isWay(int[] a) {
		// Initial pointer
		int p = 0;
		// Updates the pointer according to value stored in the first space
		if (a[0] < 0)
			p = -a[0];

		// Win condition
		if (p == a.length - 1)
			return true;

		// Lose condition - infinite loop
		if (a[p] < 0)
			return false;

		// Sets the amount of moves according to index value
		int m = a[p];
		// Checks current space as passed by
		a[p] = -1;

		// Moves forwards in array
		if (p + m < a.length) {
			// Stores next index in the first space
			a[0] = -(p + m);

			if (isWay(a))
				return true;
		}

		// Moves backwards in array
		if (p - m > 0) {
			// Stores next index in the first space
			a[0] = -(p - m);

			if (isWay(a))
				return true;
		}

		// If no way was found
		return false;
	}

	/**
	 * Prints out all the possible way to get to a mountain from the starting point
	 * (0,0) while you can only go uphill.
	 * 
	 * @param mat
	 *            - a two dimentional array
	 */
	public static void printPath(int[][] mat) {
		printPath(mat, 0, 0);
	}

	/**
	 * A private function to track the placement of the pointer in the array and
	 * print it's way to the mountain.
	 * 
	 * @param mat
	 *            - the two dimentional array
	 * @param x
	 *            - x coordinate of the pointer
	 * @param y
	 *            - y coordinate of the pointer
	 */
	private static void printPath(int[][] mat, int x, int y) {
		System.out.printf("(%d, %d)\n", x, y);

		if (!(y == mat[x].length - 1) && (mat[x][y] < mat[x][y + 1]))
			printPath(mat, x, y + 1);

		else if (!(y == 0) && (mat[x][y] < mat[x][y - 1]))
			printPath(mat, x, y - 1);

		else if (!(x == mat.length - 1) && (mat[x][y] < mat[x + 1][y]))
			printPath(mat, x + 1, y);

		else if (!(x == 0) && (mat[x][y] < mat[x - 1][y]))
			printPath(mat, x - 1, y);
	}
}