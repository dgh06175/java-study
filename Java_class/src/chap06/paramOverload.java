package chap06;

public class paramOverload {

	public static void main(String[] args) {
		paramOverload a = new paramOverload();
		System.out.println(a.plus(1, 2));
		System.out.println(a.plus(1.0, 2.0));
	}
	
	
	int plus(int x, int y) { return x + y; }
	double plus(double x, double y) { return x + y;}
}
