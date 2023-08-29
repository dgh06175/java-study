package test1;

public class Test_class {

	public static void main(String[] args) {
		String name1 = "신용권";
		String name2 = "신용권";
		String name3 = new String("신용권");
		String name4 = new String("신용권");
		System.out.println(name1 == name2); // true
		System.out.println(name1 == name3); // false
		System.out.println(name3 == name4); // false
	}

}
