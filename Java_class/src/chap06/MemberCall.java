package chap06;

public class MemberCall {
	int iv = 10;
	static int cv = 20;
	
	int iv2 = cv;
	//static int cv2 = iv; // 정적 멤버의 초기화에 인스턴스 변수인 iv는 사용할 수 없다. 꼭 사용해야 한다면, (외부에서) 객체를 사용해야 한다.
	
	static void staticMethod1() {
		System.out.println(cv);
		//System.out.println(iv); // 정적 메소드에 인스턴스 변수를 사용할 수 없다.
		// 정적 멤버가 아니라면 객체를 생성해야 사용할 수 있다.
	}
	
	void instanceMethod1() {
		System.out.println(cv);
		System.out.println(iv); // 인스턴스 메소드에서 인스턴스 변수를 사용할 수 있다.
	}
	
	static void staticMethod2() {
		staticMethod1();
		//instanceMethod1(); // 정적 메소드에 인스턴스 메소드를 사용할 수 없다.
		// 정적 멤버가 아니라면 객체를 생성해야 사용할 수 있다.
	}
	
	void instanceMethod2() {
		staticMethod1(); // 정적 멤버이므로 바로 사용 가능하다.
		instanceMethod1();
	}
}


