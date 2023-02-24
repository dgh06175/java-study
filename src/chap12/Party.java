package chap12;


public class Party {
	static class Tanker extends Thread{
		String[] action = {"방어", "방패공격", "도발"};
		@Override
		public void run() {
			for(int i=0; i<500; i++) {
				int actNum = (int)(Math.random() * 3);
				String act = action[actNum];
				System.out.println(i+1 + "턴 탱커: " + act);
				try { Thread.sleep(1000); } catch(Exception e) {}
			}
		}
	}
	
	static class Healer extends Thread{
		String[] action = {"힐", "보호막", "정화"};
		@Override
		public void run() {
			for(int i=0; i<500; i++) {
				int actNum = (int)(Math.random() * 3);
				String act = action[actNum];
				System.out.println(i+1 + "턴 힐러: " + act);
				try { Thread.sleep(1000); } catch(Exception e) {}
			}
		}
	}
	
	static class Dealer extends Thread{
		String[] action = {"공격", "범위공격", "강한공격"};
		@Override
		public void run() {
			for(int i=0; i<500; i++) {
				int actNum = (int)(Math.random() * 3);
				String act = action[actNum];
				System.out.println(i+1 + "턴 딜러: " + act);
				try { Thread.sleep(1000); } catch(Exception e) {}
			}
		}
	}
}
