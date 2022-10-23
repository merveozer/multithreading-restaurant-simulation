package capstone.merveozer.model.customer;

import java.util.List;
import java.util.Random;

import capstone.merveozer.model.table.Table;

/**
 * This class represents the customer. Each customer object is created with an
 * id and table list. totalConsumeTimeMS = eating time of the chosen food or
 * beverage totalPrepareTimeMS = chef's preparation time totalTimeMS = total
 * time spent at the table (totalConsumeTimeMS + totalPrepareTimeMS)
 * 
 * @author Merve Ozer
 */

public class Customer extends Thread implements FoodChooser, BeverageChooser, TableChooser {
	private int customerId;
	private List<Table> tables;
	private int totalConsumeTimeMS;
	private int totalPrepareTimeMS;
	private int totalTimeMS;
	private boolean served;
	private Table chosenTable;

	public Customer(int customerId, List<Table> tables) {
		this.customerId = customerId;
		this.tables = tables;
		this.served = false;
	}

	@Override
	public String toString() {
		return "Customer " + customerId;
	}

	public boolean getIsServed() {
		return served;
	}

	public void setServed(boolean served) {
		this.served = served;
	}

	public int getTotalPrepareTimeMS() {
		return totalPrepareTimeMS;
	}

	public void setTotalPrepareTimeMS(int totalPrepareTimeMS) {
		this.totalPrepareTimeMS = totalPrepareTimeMS;
	}

	public int getTotalConsumeTimeMS() {
		return totalConsumeTimeMS;
	}

	public void setTotalConsumeTimeMS(int totalConsumeTimeMS) {
		this.totalConsumeTimeMS += totalConsumeTimeMS;
	}

	public int getTotalTimeMS() {
		return totalTimeMS;
	}

	public void setTotalTimeMS(int totalTimeMS) {
		this.totalTimeMS = totalTimeMS;
	}

	public List<Table> getTables() {
		return tables;
	}

	public Table getChosenTable() {
		return chosenTable;
	}

	public void setChosenTable(Table chosenTable) {
		this.chosenTable = chosenTable;
	}

	@Override
	public void run() {
		try {
			Random random = new Random();

			this.chosenTable = (Table) tables.get(random.nextInt(tables.size()));
			System.out.println(this + " firstly chooses " + chosenTable);

			checkTablesQueue(random, this);
			chooseFood(random, this);
			chooseBeverage(random, this);

			System.out.println(this + " Total eating duration:" + this.totalConsumeTimeMS + ". Total waiting time:"
					+ totalPrepareTimeMS);
			this.totalTimeMS = this.totalConsumeTimeMS + this.totalPrepareTimeMS;

			chosenTable.addCustomer(this);
			Thread.sleep(this.totalTimeMS);
			System.out.println(this + " is finished eating");

			System.out.println(this + " spent total of " + this.totalTimeMS + " ms at the table.");
			chosenTable.removeCustomer(this);

			System.out.println(this + " leaves restaurant");
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

}
