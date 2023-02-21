package chap07;

public class SmartPhone extends Phone {
	//생성자
	public SmartPhone(String owner) {
		super(owner);
	}
	//메소드
	public void internetSearch() {
		System.out.println("인터넷 검색을 합니다.");
	}
	
	@Override
	public void phoneRing() {
		System.out.println("전화기가 울립니다.");
	}
	
	@Override
	public void reveiveMessage() {
		System.out.println("메시지를 수신했습니다.");
	}
}
