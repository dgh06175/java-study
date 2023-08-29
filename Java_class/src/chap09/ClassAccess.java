package chap09;

public class ClassAccess {
	int field1;
	void method1() {}
	
	static int field2;
	static void method2() {}
	
	//static class B {
	class B {
		void method() {
			field1 = 10;
			method1();
			
			field2 = 10;
			method2();
		}
	}
}
