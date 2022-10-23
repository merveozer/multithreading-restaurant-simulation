package capstone.merveozer;

import java.util.ArrayList;

import capstone.merveozer.model.customer.Customer;
import capstone.merveozer.model.employee.Chef;
import capstone.merveozer.model.employee.Waiter;
import capstone.merveozer.model.menu.Menu;
import capstone.merveozer.model.menu.beverages.Beverage;
import capstone.merveozer.model.menu.food.Food;
import capstone.merveozer.model.table.Table;

public class Restaurant {

	public static final int NUM_CUSTOMERS = 130;
	public static ArrayList<Food> foods = new ArrayList<Food>();
	public static ArrayList<Beverage> beverages = new ArrayList<Beverage>();
	public static ArrayList<Customer> customers = new ArrayList<>();
	public static ArrayList<Waiter> waiters = new ArrayList<>();

	public static void main(String[] args) {

		ArrayList<Table> tables = new ArrayList<>();
		tables.add(new Table("Window Seat 1"));
		tables.add(new Table("Middle"));
		tables.add(new Table("Window Seat 2"));

		Chef chef = Chef.getChef();

		waiters.add(new Waiter(1, chef));
		waiters.add(new Waiter(2, chef));
		waiters.add(new Waiter(3, chef));

		tables.get(0).setWaiter(waiters.get(0));
		tables.get(1).setWaiter(waiters.get(1));
		tables.get(2).setWaiter(waiters.get(2));
		waiters.get(0).setTable(tables.get(0));
		waiters.get(1).setTable(tables.get(1));
		waiters.get(2).setTable(tables.get(2));

		foods.add(Menu.Bruschetta);
		foods.add(Menu.Hamburger);
		foods.add(Menu.Cheesecake);

		beverages.add(Menu.Coffee);
		beverages.add(Menu.Lemonade);

		for (int i = 0; i < NUM_CUSTOMERS; i++) {
			customers.add(new Customer(i, tables));
		}

		for (Customer customer : customers) {
			customer.start();
		}

		for (Waiter waiter : waiters) {
			waiter.start();
		}
	}

}
