package chap12;

public class BeepThread extends Thread{
	@Override
	public void run() {
		for(int i=0; i<500; i++) {
			System.out.println("삡");
			try { Thread.sleep(500); } catch(Exception e) {}
		}
	}
}
