package crossingBridge;

// 화면 출력을 담당하는 클래스

public class View {
	private static String startMessage1 = "다리 건너기 게임을 시작합니다.";
	private static String startMessage3 = "한칸을 건널때 마다 0과 1을 선택해야 합니다.";
	private static String startMessage2 = "다리의 길이를 입력해주세요(1~3)";
	private static String inputMessage = "\n0 또는 1을 입력해주세요 :";
	private static String successMessage = "\n다리를 건넜습니다. 축하합니다!!!";
	private static String failMessage = "\n다리 건너기에 실패했습니다.";
	private static String nextStepMessage = "한 칸 건너기에 성공했습니다.";
	private static String div = "####################################";
	
	static void printStartMessage() {
		System.out.println(startMessage1);
		System.out.print(startMessage3);
		System.out.println(startMessage2);
	}
	
	static void printInputMessage() {
		System.out.print(inputMessage);
	}
	
	static void printSuccessMessage() {
		System.out.println(successMessage);
	}
	
	static void printFailMessage() {
		System.out.println(failMessage);
	}
	
	static void printNextStep() {
		System.out.println(nextStepMessage);
	}
	
	static void printDiv() {
		System.out.println(div);
	}
	
	static int inputMessage() {
		java.util.Scanner scanner = new java.util.Scanner(System.in);
//		String input = "";
//		while(true) {
//			input = scanner.nextLine();
//			if (input == "0" || input == "1") break;
//			else { System.out.println("0 또는 1을 입력해주세요.");}
//		}
//		return Integer.parseInt(input);
		return scanner.nextInt();
	}
}
