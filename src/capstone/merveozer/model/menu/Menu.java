package capstone.merveozer.model.menu;

import capstone.merveozer.model.menu.beverages.Beverage;
import capstone.merveozer.model.menu.beverages.BeverageType;
import capstone.merveozer.model.menu.food.Food;
import capstone.merveozer.model.menu.food.FoodType;

public class Menu {

	public static Food Bruschetta = new Food("Bruschetta", FoodType.APPETIZER, 6000, 2000, 20.0);
	public static Food Hamburger = new Food("Hamburger", FoodType.MAIN, 8000, 3000, 50.0);
	public static Food Cheesecake = new Food("Cheesecake", FoodType.DESSERT, 2000, 500, 40.0);

	public static Beverage Coffee = new Beverage("Coffee", BeverageType.HOT, 1000, 10.0);
	public static Beverage Lemonade = new Beverage("Lemonade", BeverageType.COLD, 1000, 10.0);

	//public static Treat Treat = new Treat("Treat", 2000);
	
}
