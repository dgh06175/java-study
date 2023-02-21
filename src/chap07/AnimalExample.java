package chap07;

public class AnimalExample {

	public static void main(String[] args) {
		Dog dog = new Dog();
		Frog frog = new Frog();
		dog.sound(); // (1)번 조건
		frog.sound(); // (1)번 조건
		System.out.println("--------------");
		
		Animal animal = dog;
		animal.sound(); // (2)번 조건
		animal = frog;
		animal.sound(); // (2)번 조건
		System.out.println("--------------");
		
		printAnimalInfo(dog); // (3)번 조건
		printAnimalInfo(frog); // (3)번 조건
		
	}
	
	public static void printAnimalInfo(Animal animal) {
		animal.sound();
		animal.breathe();
		System.out.println(animal.kind + "입니다.\n");
	}

}
