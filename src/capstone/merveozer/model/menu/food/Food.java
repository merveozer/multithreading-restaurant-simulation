package capstone.merveozer.model.menu.food;

import java.util.List;

import capstone.merveozer.model.menu.MenuItem;
import capstone.merveozer.model.menu.Preparable;
import capstone.merveozer.model.menu.Priceable;

public class Food extends MenuItem implements Preparable, Priceable, Comparable<Food>{
	
	private FoodType type;
	private int prepareTimeMS;
	private double price;

	public Food(String name, FoodType type, int consumeTimeMS, int prepareTimeMS, double price) {
		super(name, consumeTimeMS);
		this.type = type;
		this.prepareTimeMS = prepareTimeMS;
		this.price = price;
	}

	public FoodType getType() {
		return type;
	}

	public int getPrepareTimeMS() {
		return prepareTimeMS;
	}

	public double getPrice() {
		return price;
	}
	

	@Override
	public void setPrepareTime(int prepareTimeMS) {
		this.prepareTimeMS = prepareTimeMS;
	}
	

	@Override
	public void makeDiscount() {
		double newPrice = this.price - (this.price * 0.1);
		this.price = newPrice;
		System.out.println("New price is: " + this.price);
		
	}
	
	
	@Override
	public void prepareFaster() {
		this.prepareTimeMS = this.prepareTimeMS - 1000;	
		System.out.println("New prepare time is: " + this.prepareTimeMS);
	}

	@Override 
	public int compareTo(Food food) {
		if(this.getPrice() == food.getPrice()) {
			return 0;
		}else
		return this.getPrice() > food.getPrice() ? 1 : -1;
	}

	public static void lowestPrepareTime(List<Food> foods) {
		Food minPrepareFood = foods.get(0);
		for (Food food : foods) {
		    if (food.getPrepareTimeMS() < minPrepareFood.getPrepareTimeMS()) {
		       minPrepareFood  = food;
		    }
		}
		System.out.println(minPrepareFood.getName());
	}


}