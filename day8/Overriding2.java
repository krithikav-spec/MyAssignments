package week3.day8;

public class Overriding2 extends Overriding1 {

	public void method1() {
		super.method1();
		System.out.println("method1");
	}

	public void method2() {
		System.out.println("method2");
	}

	public void method3() {
		System.out.println("method3");
	}

	public static void main(String[] args) {

		Overriding2 obj2 = new Overriding2();
		obj2.method1();
		obj2.method2();
		obj2.method3();
		

	}
}
