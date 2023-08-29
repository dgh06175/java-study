package chap12;

public class BeepPrintExample2 {
	public static void main(String[] args) {
		Runnable beepTask1 = new BeepTask(1);
		Runnable beepTask2 = new BeepTask(2);
		Runnable beepTask3 = new BeepTask(3);
		
		Thread thread1 = new Thread(beepTask1);
		Thread thread2 = new Thread(beepTask2);
		Thread thread3 = new Thread(new Runnable() {
			public void run() {
				for(int i = 0; i < 500; i++) {		
					System.out.println("DDing " + 3);
					try { Thread.sleep(500); } catch(Exception e) {}
				}
			}
		}
		);

		thread1.start();
		thread2.start();
		thread3.start();

		
		for(int i=0; i<500; i++) {
			System.out.println("띵");
			try { Thread.sleep(500); } catch(Exception e) {}
		}
	}
}


