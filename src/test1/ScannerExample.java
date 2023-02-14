package test1;
import java.util.Scanner;

public class ScannerExample {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			String inputData = scanner.nextLine();
			System.out.println("입력된 문자열 ㅣ \"" + inputData + "\"");
			if (inputData.equals("q")) {
				break;
			}
		}
	}
}
