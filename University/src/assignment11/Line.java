package assignment11;

import java.util.Scanner;

public class Line {

	public static void main(String[] args) {
		int x1, y1, x2, y2;
		double distance;

		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter 4 integers ");
		
		/*Receiving the first dot's coordinates*/
		System.out.print("Enter the x coordinates of the first dot: ");
		x1 = scan.nextInt();
		System.out.print("Enter the y coordinates of the first dot: ");
		y1 = scan.nextInt();
		
		/*Receiving the first dot's coordinates*/
		System.out.print("Enter the x coordinates of the second dot: ");
		x2 = scan.nextInt();
		System.out.print("Enter the y coordinates of the second dot: ");
		y2 = scan.nextInt();
		
		/*Calculates the distance*/
		distance = Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));

		/*Prints the dots and the distance*/
		System.out.printf("\nThe length of the line between the points"
				+ " (%d,%d) and (%d,%d) is %f", x1, y1, x2, y2, distance);
		
		scan.close();
	}//End of main
	
}//End of class