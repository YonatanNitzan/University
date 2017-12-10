package testing;

public class B extends A {
	public B() {
		System.out.println("In B");
	}

	public void f() {
		_x = 2;
		_y = 3;
		System.out.println("In B's f");
	}

	public void g() {
		System.out.println("In g");
	}
}
