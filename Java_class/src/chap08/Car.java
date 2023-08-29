package chap08;

public class Car {
	//필드
	Tire frontLeftTire = new HankookTire("앞왼쪽");
	Tire frontRightTire = new KumhoTire("앞오른쪽");
	Tire backLeftTire = new HankookTire("뒤왼쪽");
	Tire backRightTire = new KumhoTire("뒤오른쪽");
	
	//생성자
	
	//메소드
	int run() {
		System.out.println("[자동차가 달립니다.]");
		if(frontLeftTire.roll()==false) { stop(); return 1; };
		if(frontRightTire.roll()==false) { stop(); return 2; };
		if(backLeftTire.roll()==false) { stop(); return 3; };
		if(backRightTire.roll()==false) { stop(); return 4; };
		return 0;
	}
	
	void stop() {
		System.out.println("[자동차가 멈춥니다.]");
	}
}
