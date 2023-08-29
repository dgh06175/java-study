package chap08;

public class Water implements Drink {
	@Override
	public void drink() {
		System.out.println("물을 마십니다.");
	}

	public void drop() {
		System.out.println("물을 버립니다.");
	}
}
