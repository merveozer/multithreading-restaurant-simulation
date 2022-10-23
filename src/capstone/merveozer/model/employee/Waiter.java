package capstone.merveozer.model.employee;

import java.util.concurrent.Semaphore;

import capstone.merveozer.model.customer.Customer;
import capstone.merveozer.model.table.Table;

/**
 * Each waiter is assigned to a table.
 */
public class Waiter extends Thread {

	private int waiterId;
	private Table table;
	private Chef chef;
	private Semaphore semaphore;
	protected Customer customer;

	public Waiter(int waiterId, Chef chef) {
		this.waiterId = waiterId;
		this.chef = chef;
		semaphore = new Semaphore(0);
	}

	public void setTable(Table table) {
		this.table = table;
	}

	public void callWaiter() {
		semaphore.release();
	}

	/**
	 * Waits for a call from the assigned table then forwards the calling customer
	 * to the chef. If there is no customer from serveNextCustomer method stops
	 * working.
	 */

	@Override
	public void run() {
		try {
			while (true) {
				semaphore.acquire();
				this.customer = table.serveNextCustomer();

				if (customer == null) {
					break;
				}

				System.out.println(this + " is now serving " + customer);
				chef.cook(this);
				Thread.sleep(1000);
				customer.setServed(true);
				System.out.println(this + " has served " + customer);
				semaphore.release();
			}
			System.out.println(this + " left the restaurant");
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	@Override
	public String toString() {
		return "Waiter " + waiterId;
	}

}
