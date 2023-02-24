package chap12;

public class HelloThread extends Thread {
	@Override
	public void run() {
		for(int i=0; i<500; i++) {		
			System.out.println(i+1 + "번째 안녕");
			try { Thread.sleep(500); } catch(Exception e) {}
		}
	}
}
