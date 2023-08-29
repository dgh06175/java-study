package chap09;

class Listener {
	public static class CallListener implements Button.OnClickListener {
		@Override
		public void onClick() {
			System.out.println("전화를 겁니다.");
		}
		
	}
	
	public static class MessageListener implements Button.OnClickListener{
		@Override
		public void onClick() {
			System.out.println("메시지를 보냅니다.");
		}
	}
}