package crossingBridge;

// 다리 건너기 게임을 수행하는 클래스

public class Play {
	public static void main(String[] args) {
		View.printStartMessage();
		int len = View.inputMessage();
		Bridge b = new Bridge(len);
		int continueGame = 1;
		while(continueGame == 1) {
			boolean success = true;
			View.printDiv();
			for (int i=0; i<len; i++) {
				View.printInputMessage();
				int input = View.inputMessage();
				if (input == 1) {
					if (b.getBridge()[i] == 1) {
						View.printNextStep();
						b.printBridge(i + 1);
						continue;
					} else {
						b.printBridge(i + 1);
						success = false;
						break;
					}
				} else {
					if (b.getBridge()[i] == 0) {
						View.printNextStep();
						b.printBridge(i + 1);
						continue;
					} else {
						b.printBridge(i + 1);
						success = false;
						break;
					}
				}
			}
			if (success) View.printSuccessMessage();
			else View.printFailMessage();
			System.out.print("게임을 다시 할거면 1을 입력해주세요. 아니라면 다른것을 입력하세요 : ");
			continueGame = View.inputMessage();
		}
		
		
	}
}
