package chap08;

public class DrinkExample {

	public static void main(String[] args) {
		Drinker drinker = new Drinker();
		drinker.drinking(new Coffee());
		drinker.drinking(new Water());

		
		
		Drink drink1  = new Coffee();
		Drink drink2  = new Water();

		// drink1.drop();
		// drink2.drop();
		Coffee coffee = (Coffee) drink1; // 강제타입변환
		coffee.drop();
		Water water = (Water) drink2; // 강제타입변환
		water.drop();
	}
}
