package chap12;

public class BeepPrintExample4 {

	public static void main(String[] args) {
		Thread thread = new Thread() {
			@Override
			public void run() {
				for(int i=0; i<500; i++) {
					System.out.println("삡");
					try { Thread.sleep(500); } catch(Exception e) {}
				}
			}
		};
		
		
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				for(int i=0; i<500; i++) {	
					System.out.println(i+1 + "번째 안녕");
					try { Thread.sleep(500); } catch(Exception e) {}
				}
			}
		};
		thread.start();
		thread2.start();
		
		for(int i=0; i<500; i++) {
			System.out.println("띵");
			try {Thread.sleep(500);} catch(Exception e) {}
		}
	}

}
