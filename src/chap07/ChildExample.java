package chap07;

public class ChildExample {

	public static void main(String[] args) {
		Child child = new Child();
		Parent parent = child;
		child.method1();
		child.method2();
		child.method3();

		parent.method1();
		parent.method2();
		//parent.method3(); // 자식 클래스로 형변환되어서 method3은 불가

	}

}
