package chap12;

public class BattleExample {
	public static void main(String[] args) {
		Thread tanker = new Party.Tanker();
		Thread healer = new Party.Healer();
		Thread dealer = new Party.Dealer();

		tanker.start();
		healer.start();
		dealer.start();
	}
}
