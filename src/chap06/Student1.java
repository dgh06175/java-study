package chap06;

public class Student1 {
	String name = new String("이상현");
	int ban = 6; // 반
	int no = 31; // 번호
	int kor = 57; // 국어점수
	int eng = 72; // 영어점수
	int math = 94; // 수학점수
	
	int getTotal() {
		return kor + eng + math;
	}
	
	float getEverage() {
		return (int)(getTotal() / 3f * 10 + 0.5f) / 10f;
	}
}
