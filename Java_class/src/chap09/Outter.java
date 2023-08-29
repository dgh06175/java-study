package chap09;

public class Outter {
	String field = "Outter-field";
	void method() {
		System.out.println("Outter-method");
	}
	
	class Nested {
		String field = "Nested-field";
		void method() {
			System.out.println("Nested-method");
		}
		void print() {
			System.out.println(this.field); // Nest~fi
			this.method(); // Nesr~me
			System.out.println(Outter.this.field); //Out~fi
			Outter.this.method(); //Outter-me
		}
	}
}
