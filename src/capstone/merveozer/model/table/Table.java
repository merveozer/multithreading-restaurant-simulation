package capstone.merveozer.model.table;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import capstone.merveozer.model.customer.Customer;
import capstone.merveozer.model.employee.Waiter;

/**
 * This class has one Queue that keeps customers in the queue. Tables are for
 * four people. If the table selected by the customer is full, the customer is
 * added to the queue.
 * 
 * @author Merve Ozer
 */

public class Table {
	private String name;
	private Waiter waiter;
	private List<Customer> seats;
	private Queue<Customer> queue;

	public Table(String name) {
		this.name = name;
		seats = new ArrayList<>();
		queue = new LinkedList<>();
	}

	public void setWaiter(Waiter waiter) {
		this.waiter = waiter;
	}

	public int getQueueSize() {
		return queue.size();
	}

	public int getSeatSize() {
		return seats.size();
	}

	public Customer serveNextCustomer() {
		try {
			for (Customer customer : seats) {
				if (!customer.getIsServed()) {
					return customer;
				}
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		return null;
	}

	public void removeCustomer(Customer customer) {
		try {
			seats.remove(customer);
			System.out.println(customer + " is done with " + this);
			if (!queue.isEmpty()) {
				Customer nextCustomer = (Customer) queue.poll();
				seats.add(nextCustomer);
				System.out.println(nextCustomer + " sat on " + this);
				waiter.callWaiter();
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	public void addCustomer(Customer customer) {
		{
			try {
				if (customer.getChosenTable().getSeatSize() < 4) {
					seats.add(customer);
					System.out.println(customer + " sat on " + this);
					waiter.callWaiter();
				} else {
					queue.add(customer);
					System.out.println(customer + " lined up for " + this);
				}
			} catch (Exception e) {
				e.printStackTrace(System.out);
			}
		}
	}

	@Override
	public String toString() {
		return "Table " + name;
	}

}
