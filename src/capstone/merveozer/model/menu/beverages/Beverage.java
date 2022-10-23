package capstone.merveozer.model.menu.beverages;

import capstone.merveozer.model.menu.MenuItem;
import capstone.merveozer.model.menu.Priceable;

public class Beverage extends MenuItem implements Priceable{

	private BeverageType type;
	private double price;
	
	public Beverage(String name, BeverageType type, int consumeTimeMS, double price) {
		super(name, consumeTimeMS);
		this.type = type;
		this.price = price;
	}

	public BeverageType getType() {
		return type;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public void makeDiscount() {
		this.price = this.price - (this.price * 0.1);
		
	}

	
}
