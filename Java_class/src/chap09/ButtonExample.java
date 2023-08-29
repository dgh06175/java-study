package chap09;

public class ButtonExample {
	public static void main(String[] args) {
		Button btn = new Button();
		
		btn.setOnClickListener(new Listener.CallListener());
		btn.touch();
		
		btn.setOnClickListener(new Listener.MessageListener());
		btn.touch();
	}
}
