
package com.example.bankops;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigService {

    private static final Logger log = LoggerFactory.getLogger(ConfigService.class);

    /**
     * Returns the configured daily limit. Intentionally broken:
     * - Uses a bad default value that cannot be parsed as an integer.
     *   This will throw NumberFormatException at runtime.
     */
    public int getDailyLimit() {
        String raw = System.getProperty("DAILY_LIMIT", "LIMIT_1000"); // broken default
        log.info("Raw DAILY_LIMIT config value: '{}'", raw);

        // This line will throw NumberFormatException for the default value
        int value = Integer.parseInt(raw);

        if (value <= 0) {
            log.warn("Configured DAILY_LIMIT {} is not positive, using fallback 1", value);
            return 1;
        }

        return value;
    }
}
