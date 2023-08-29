package chap12;

//import java.awt.Toolkit;

public class BeepTask implements Runnable {	
	int num;
	
	public BeepTask(int n){
		num = n;
	}
	
	public void run() {		
		//Toolkit toolkit = Toolkit.getDefaultToolkit();	
		for(int i=0; i<500; i++) {		
			//toolkit.beep();
			System.out.println("DDing " + num);
			try { Thread.sleep(500); } catch(Exception e) {}
		}
	}
}

