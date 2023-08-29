package chap08;

public class HankookTire implements Tire {
	//필드
	public String location;
	public int accumulatedRotation;
	//생성자
	public HankookTire(String location) {
		this.location = location;
	}
	
	//메소드
	@Override
	public boolean roll() {
		++accumulatedRotation;		
		if(accumulatedRotation < MAX_ROTATION) {
			System.out.println(location + " HankookTire 수명: " + (MAX_ROTATION - accumulatedRotation) + "회");
			return true;
		} else {
			System.out.println("*** " + location + " HankookTire 펑크 ***");
			return false;
		}
	}
}

