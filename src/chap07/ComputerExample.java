package chap07;

public class ComputerExample {

	public static void main(String[] args) {
		int r = 10;
		Calculator calculator = new Calculator();
		System.out.println("calculator : " + calculator.areaCircle(r));
		System.out.println();
		Computer computer = new Computer();
		System.out.println("computer : " + computer.areaCircle(r));

	}

}
