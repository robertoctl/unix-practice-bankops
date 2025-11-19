
# Unix Practice - Bank Ops Logging App

This is a **small Java 17 console app** designed for practice with:

- Unix commands (`grep`, `find`, `awk`, `less`, `vim`, etc.)
- Reading and understanding log files
- Finding and fixing runtime exceptions in Java
- Creating a Pull Request with a fix

## How the app behaves

When you run the app, it will:

1. Start normally and log its progress.
2. Try to read a configuration value `DAILY_LIMIT`.
   - The default value is intentionally invalid: `LIMIT_1000`.
   - This causes a **NumberFormatException**.
3. Then it tries to process a non-existing customer id `CUST-9999`.
   - This causes a **NullPointerException** in `CustomerService`.

Both errors are logged to `logs/app.log` using Logback.

## Build and run

```bash
mvn compile
mvn exec:java
```

Logs will be written to:

```bash
logs/app.log
```

A sample, larger log file is included here:

```bash
sample-logs/app.log
```

## Suggested student exercises (Unix focus)

- Use `find` to locate all `.log` files in the project.
- Use `grep` to search for:
  - `Exception`
  - `NumberFormatException`
  - `NullPointerException`
  - `BankOpsApplication`
  - `CustomerService`
- Use `grep -n` to find the line numbers of errors.
- Use `awk` to:
  - Extract only log levels or timestamps.
  - Count how many ERROR lines exist.
- Use `less` to navigate the log file.
- Use `vim` or another editor to read and modify Java source files.

## Suggested student exercises (Java/PR focus)

- Fix the **NumberFormatException** in `ConfigService.getDailyLimit()`:
  - Validate the string before parsing.
  - Or change the default to a numeric value.
  - Or handle the exception and log a clearer message.
- Fix the **NullPointerException** in `CustomerService.processCustomer()`:
  - Check if `customer` is null before using it.
  - Decide what to log or how to handle the missing customer.

Then:

1. Run the app again.
2. Verify that no exceptions are thrown.
3. Check that `logs/app.log` no longer contains stack traces.
4. Create a Pull Request with your changes.
