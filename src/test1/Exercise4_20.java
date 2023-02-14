package test1;

public class Exercise4_20 {

	public static void main(String[] args) {
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		System.out.println("money=");
		int money = scanner.nextInt();
		System.out.println("500원: " + money / 500);
		money %= 500;
		System.out.println("100원: " + money / 100);
		money %= 100;
		System.out.println("50원: " + money / 50);
		money %= 50;
		System.out.println("10원: " + money / 10);
	}

}
