package chap10;

public class ArrayIndexOutOfBoundsExceptionExample {

	public static void main(String[] args) {
		String data1 = args[0];
		String data2 = args[1];
		
		System.out.println("arge[0] : " + data1);
		System.out.println("arge[0] : " + data2);
		
		if(args.length == 2) {
			String data3 = args[0];
			String data4 = args[1];
			System.out.println("args[0]: " + data3);
			System.out.println("args[1]: " + data4);
		} else {
			System.out.println("두개의 실행 매개값이 필요합니다.");
		}
	}

}
