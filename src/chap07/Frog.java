package chap07;

public class Frog extends Animal{
	public Frog() {
		this.kind = "양서류";
	}
	
	@Override
	public void sound() {
		System.out.println("개굴~ 개굴~");
	}
}

// 1. sound 함수 호출
// 2. Animal 변수로 타입변환해서 sound()함수 호출
// 3. 부모타입의 매개변수에 자식객체를 대입해서 매개변수의 다형성 이
