package testing;

import java.util.Scanner;

public class Lesson_1 {

	public static void main(String[] args) {
		new Lesson_1();
	}

	public Lesson_1() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter your name: ");
		MyName(sc.next());
		
		System.out.print("\nEnter a number: ");
		SquareCube(sc.nextInt());
		
		sc.close();
	}

	public void MyName(String name)
	{
		for (int i = 0; i < (name.length() + 2); i++) 
		{
			System.out.print("*");
		}
		
		System.out.printf("\n*%s*\n", name);
		
		for (int i = 0; i < (name.length() + 2); i++) 
		{
			System.out.print("*");
		}
	}
	
	private void SquareCube(int num) {
		System.out.println(num);
		
		int square = num * num;
		System.out.println(square);
		
		int cube = square * num;
		System.out.println(cube);
	}

}
