
package com.example.bankops;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("=== Starting Bank Operations App ===");
        BankOpsApplication app = new BankOpsApplication();
        try {
            app.run();
        } catch (Exception e) {
            log.error("Fatal error during application run", e);
        } finally {
            log.info("=== Application finished ===");
        }
    }
}
