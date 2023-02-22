package chap08;

public interface Tire {
//	//필드
	public int MAX_ROTATION = (int)(Math.random() * 10);
//	public int maxRotation;     		//최대 회전수(최대 수명)
//	public int accumulatedRotation;		//누적 회전수
//	public String location;       		//타이어의 위치

//	//생성자
//	public Tire(String location, int maxRotation) {
//		this.location = location;
//		this.maxRotation = maxRotation;
//	}
	
	//메소드
	public boolean roll();
}
