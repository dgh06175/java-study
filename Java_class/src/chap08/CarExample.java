package chap08;

public class CarExample {
	public static void main(String[] args) {
		Car car = new Car();

		for (int i = 1; i <= 10; i++) {
			int problemLocation = car.run();
			switch (problemLocation) {
			case 1:
				System.out.println("앞왼쪽 HankookTire로 교체");
				car.frontLeftTire = new HankookTire("앞왼쪽");
				break;
			case 2:
				System.out.println("앞오른쪽 KumhoTire로 교체");
				car.frontRightTire = new KumhoTire("앞오른쪽"); // 형은 부모꺼지만 실질적인 호출은 자식 꺼
				break;
			case 3:
				System.out.println("뒤왼쪽 HankookTire로 교체");
				car.backLeftTire = new HankookTire("뒤왼쪽");
				break;
			case 4:
				System.out.println("뒤오른쪽 KumhoTire로 교체");
				car.backRightTire = new KumhoTire("뒤오른쪽");
				break;
			}
			System.out.println("----------------------------------------");
		}
	}
}
