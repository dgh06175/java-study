package chap06;

public class Calculator {
	static double pi = 3.141592;
	
	static int plus(int ... value) {
		return value[0] + value[1];
	}
	
	static int minus(int ... value) {
		return value[0] - value[1];
	}
}
