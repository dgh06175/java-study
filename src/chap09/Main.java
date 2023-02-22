package chap09;

public class Main {

	public static void main(String[] args) {
		A a = new A();
		
		A.B b = a.new B();
		b.field1 = 3;
		b.method1();
		
		A.C c = new A.C(); //static이므로 a안거치고 생성가능
		c.field1 = 3;
		c.field2 = 4;
		c.method1();
		c.method2();
//		A.C.field1 = 2;
		A.B.field2 = 3;
		A.C.method2();
		
		a.method();
	}

}
