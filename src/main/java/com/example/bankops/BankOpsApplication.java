
package com.example.bankops;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BankOpsApplication {

    private static final Logger log = LoggerFactory.getLogger(BankOpsApplication.class);

    private final ConfigService configService = new ConfigService();
    private final CustomerService customerService = new CustomerService();

    public void run() {
        log.info("Initializing bank operations workflow...");

        log.info("Loading configuration for daily limit...");
        int dailyLimit = configService.getDailyLimit(); // NumberFormatException expected

        log.info("Loaded daily limit: {}", dailyLimit);
        log.info("Processing customer operations...");

        // Intentionally using a non-existing customer id to trigger NullPointerException
        customerService.processCustomer("CUST-9999");

        log.info("Bank operations workflow completed successfully.");
    }
}
