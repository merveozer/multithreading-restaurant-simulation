package capstone.merveozer.model.employee;

import java.util.concurrent.Semaphore;

/**
 * Only the best chef in the world works in the restaurant. So make sure there
 * is only one instance of chef. (That's why the singleton was used)
 * 
 * @author Merve Ozer
 */

public class Chef {

	private String chefName;
	private Semaphore semaphore;

	private static Chef mostFamousChef = new Chef("Best Chef in the World");

	private Chef(String chefName) {
		this.chefName = chefName;
		semaphore = new Semaphore(3);
	}

	public static Chef getChef() {
		return mostFamousChef;
	}

    public void cook(Waiter waiter) {

		try {
			semaphore.acquire();
			System.out.println(waiter + " reported " + waiter.customer + " 's order. It will be ready in "
					+ waiter.customer.getTotalPrepareTimeMS() + " MS");
			Thread.sleep(waiter.customer.getTotalPrepareTimeMS());
			System.out.println(waiter.customer + "'s order is ready!");
			semaphore.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
