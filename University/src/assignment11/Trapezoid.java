package assignment11;

import java.util.Scanner;

public class Trapezoid {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		/*Receives the information of the first base*/
		System.out.println("Please enter the left point coordinates "
				+ "of the base followed by its length:");
		int x1 = scan.nextInt();
		int y1 = scan.nextInt();
		int base1 = scan.nextInt();
		
		/*Receives the information of the second base*/
		System.out.println("Please enter the left point coordinates "
				+ "of the other base followed by its length:");
		int x2 = scan.nextInt();
		int y2 = scan.nextInt();
		int base2 = scan.nextInt();
		
		/*Calculates the legs of the trapezoid*/
		double leg1 = Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
		double leg2 = Math.sqrt(Math.pow(((x1 + base1) - (x2 + base2)), 2) + Math.pow((y1 - y2), 2));
		
		/*Calculations*/
		double area = ((double)(Math.abs(y1-y2) * (base1 + base2))/2);
		double perimeter = (base1 + base2 + leg1 + leg2);
		
		/*Prints results*/
		System.out.print("The area of the trapezoid is: " + area);
		System.out.print("\nThe perimeter of the trapezoid is: " + perimeter);
		
		scan.close();
	}//End of main
	
}//End of class