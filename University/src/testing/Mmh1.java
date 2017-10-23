package testing;

import java.util.Scanner;

public class Mmh1 {

	public static void main(String[] args) {
		int a, b, c;
		
		Scanner sc = new Scanner(System.in);
		
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		
		if (a < b)
			if (b > c)
				System.out.println("max = " + b);
			else
				System.out.println("max = " + c);
		else
			if (a > c)
				System.out.println("max = " + a);
			else
				System.out.println("max = " + c);
		
		sc.close();
	}

}
