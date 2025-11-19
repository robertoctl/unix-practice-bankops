
package com.example.bankops;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class CustomerService {

    private static final Logger log = LoggerFactory.getLogger(CustomerService.class);

    private final Map<String, Customer> customers = new HashMap<>();

    public CustomerService() {
        // Pretend these customers came from a database
        customers.put("CUST-1001", new Customer("CUST-1001", "Ada Lovelace"));
        customers.put("CUST-1002", new Customer("CUST-1002", "Alan Turing"));
        customers.put("CUST-1003", new Customer("CUST-1003", "Grace Hopper"));
    }

    /**
     * Intentionally broken: does not check for null before using the customer.
     * If the id does not exist in the map, this will throw NullPointerException.
     */
    public void processCustomer(String customerId) {
        log.info("Processing customer with id {}", customerId);

        Customer customer = customers.get(customerId); // may be null
        log.debug("Loaded customer object: {}", customer);

        // This line will throw NullPointerException when customer is null
        String upperName = customer.getName().toUpperCase();

        log.info("Processed customer {}, upper-case name: {}", customerId, upperName);
    }
}
