package base;

import java.util.HashMap;
import java.util.Map;

public enum Record {
	INSTANCE;

	Map<Integer, Customer> customers = new HashMap<>();
	
	public void addToCustomers(Customer customer) {
		customers.put(customer.gethID(), customer);
	}

	public Map<Integer, Customer> getCustomers() {
		return customers;
	}
	
	
}
