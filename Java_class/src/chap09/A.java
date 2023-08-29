package chap09;

/**바깥 클래스**/
public class A {
	A() {
		System.out.println("A 객체 생성됨");
	}
	
	/**인스턴스 멤버 클래스**/
	public class B {
		B() {
			System.out.println("B 객체 생성됨");
		}
		int field1;
		static int field2;
		void method1() {
			System.out.println("B 객체의 method1 실행됨");
		}
		static void method2() {
			System.out.println("B 객체의 method2 실행됨");
		}
	}
	
	/**정적 멤버 클래스**/
	static class C {
		C() {
			System.out.println("C 객체 생성됨");
		}
		int field1;
		static int field2;
		void method1() {
			System.out.println("C 객체의 method1 실행됨");
		}
		static void method2() {
			System.out.println("C 객체의 method2 실행됨");
		}
	}
	
	void method() {
		System.out.println("A 객체의 method 실행됨");
		/**로컬 클래스**/
		class D {
			D() {
				System.out.println("D 객체 생성됨");
			}
			int field1;
			static int field2;
			void method1() {
				System.out.println("D 객체의 method1 실행됨");
			}
			static void method2() {
				System.out.println("D 객체의 method2 실행됨");
			}
		}
		D d = new D();
		d.field1 = 3;
		d.method1();
	}
}
