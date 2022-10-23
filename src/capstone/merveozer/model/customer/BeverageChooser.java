package capstone.merveozer.model.customer;

import java.util.Random;

import capstone.merveozer.Restaurant;
import capstone.merveozer.model.menu.beverages.Beverage;

/**
 * The customer can choose at most one beverage. The duration of the selected
 * beverage should be added to the customer's time.
 * 
 * @author Merve Ozer
 */
public interface BeverageChooser {

	default void chooseBeverage(Random random, Customer customer) {
		int consumeTime = 0;

		for (int i = 0; i < random.nextInt(2); i++) {
			Beverage beverage = (Beverage) Restaurant.beverages.get(random.nextInt(Restaurant.beverages.size()));
			System.out.println(
					customer + " choose a " + beverage.getName() + ". Drinking time: " + beverage.getConsumeTimeMS());
			consumeTime += beverage.getConsumeTimeMS();

		}
		customer.setTotalConsumeTimeMS(consumeTime);
	}
}
