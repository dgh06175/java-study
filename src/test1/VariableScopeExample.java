package test1;

public class VariableScopeExample {

	public static void main(String[] args) {
		int v1 = 15;
		if (v1 > 10){
			int v2 = v1 - 10;
		}
		int x = 1;
		int y = 2;
		double result = (double) x / y;
		String str = String.valueOf(result);
		System.out.println(str);
	}

}
