package capstone.merveozer.model.customer;

import java.util.Random;

import capstone.merveozer.Restaurant;
import capstone.merveozer.model.menu.food.Food;

/**
 * The maximum number of foods that the customer can choose is two. The duration
 * of the selected foods should be added to the customer's time.
 * 
 * @author Merve Ozer
 */
public interface FoodChooser {

	default void chooseFood(Random random, Customer customer) {

		int consumeTime = 0;
		int prepareTime = 0;

		for (int i = 0; i < random.nextInt(2) + 1; i++) {

			Food food = (Food) Restaurant.foods.get(random.nextInt(Restaurant.foods.size()));
			System.out.println(customer + " choose a " + food.getName() + ". Preparation time:"
					+ food.getPrepareTimeMS() + ". Eating time:" + food.getConsumeTimeMS());
			consumeTime += food.getConsumeTimeMS();
			prepareTime += food.getPrepareTimeMS();
		}
		customer.setTotalConsumeTimeMS(consumeTime);
		customer.setTotalPrepareTimeMS(prepareTime);

	}
}
