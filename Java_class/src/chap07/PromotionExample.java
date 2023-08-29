package chap07;

public class PromotionExample {
	// B와 C는 A를 상속받음
	// D는 B를 상속받음
	// E는 C를 상속받음
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		C c = new C();
		D d = new D();
		E e = new E();		
		
		A a1 = b;
		A a2 = c;
		A a3 = d;
		A a4 = e;
		
		B b1 = d;
		C c1 = e;
		
		

		//B b3 = e;
		//C c2 = d;
	}
}

