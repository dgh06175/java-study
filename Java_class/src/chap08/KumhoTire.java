package chap08;

public class KumhoTire implements Tire {
	//필드
	public String location;
	public int accumulatedRotation;
	//생성자
	public KumhoTire(String location) {
		this.location = location;
	}
	
	//메소드
	@Override
	public boolean roll() {
		++accumulatedRotation;		
		if(accumulatedRotation < MAX_ROTATION) {
			System.out.println(location + " KumhoTire 수명: " + (MAX_ROTATION - accumulatedRotation) + "회");
			return true;
		} else {
			System.out.println("*** " + location + " KumhoTire 펑크 ***");
			return false;
		}
	}
}

