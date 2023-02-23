package chap09;

public class AnonymousExample {
	public static void main(String[] args) {
		Anonymous anony = new Anonymous();
		System.out.println("1");
		
		//익명 객체 필드 사용
		anony.field.wake();
		System.out.println("2");
		
		//익명 객체 로컬변수 사용
		anony.method1();
		System.out.println("3");

		//익명 객체 매개값 사용
		anony.method2(
			new Person() {
				void study() {
					System.out.println("공부합니다.");
				}
				@Override
				void wake() {
					System.out.println("8시에 일어납니다.");
					study();
				}
			}
		);
	}
}
