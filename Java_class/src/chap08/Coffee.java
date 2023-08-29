package chap08;

public class Coffee implements Drink {
	@Override
	public void drink() {
		System.out.println("커피를 마십니다.");
	}
	
	public void drop() {
		System.out.println("커피를 버립니다.");
	}
}
