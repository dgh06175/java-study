package chap06;

public class Exercise6_5 {

	public static void main(String[] args) {
		Student s = new Student("이상현", 1, 1, 100, 60, 76);
		System.out.println(s.info());
	}

}

class Student {
	String name;
	int ban;
	int no;
	int math;
	int eng;
	int kor;
	Student(String name, int ban, int no, int math, int eng, int kor){
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.math = math;
		this.eng = eng;	
		this.kor = kor;
	}
	String info() {
		return (name);
	}
}
