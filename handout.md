
# Student Handout — UNIX Log Analysis + Java Debugging Challenge

## Learning Objectives
By completing this activity, you will learn to:

### UNIX Skills
- Use basic UNIX commands such as `find`, `grep`, `awk`, `less`, `vim`, etc.
- Navigate a project directory.
- Analyze large logs to find operational issues.
- Extract insights from structured and unstructured logs.

### Java Debugging Skills
- Identify exceptions from stack traces.
- Inspect and fix Java code.
- Run, test, and validate fixes.
- Understand logging in real applications.

### Collaboration Skills
- Create a Pull Request.
- Document your bug fix.
- Work as a team to troubleshoot errors.

## Background
You are part of the **Bank Operations QA Team**.  
A Java application named **BankOps** is generating unexpected errors in production.

Your mission:
1. Run the app.
2. Inspect the logs.
3. Identify the source of exceptions.
4. Fix the code.
5. Submit a Pull Request with your fix.

## Project Structure

```
unix-practice-bankops/
 ├─ pom.xml
 ├─ README.md
 ├─ sample-logs/app.log
 └─ src/main/java/com/example/bankops/
     ├─ Main.java
     ├─ BankOpsApplication.java
     ├─ ConfigService.java
     ├─ CustomerService.java
     └─ Customer.java
```

## PART 1 — Run the Application

Navigate to the project:
```bash
cd unix-practice-bankops
```

Build and run:
```bash
mvn compile
mvn exec:java
```

Expected:
- INFO logs print
- A **NumberFormatException**
- A **NullPointerException**
- Logs written to: `logs/app.log`

## PART 2 — Explore Logs with UNIX Commands

### Find all log files
```bash
find . -name "*.log"
```

### View log content
```bash
less sample-logs/app.log
```

### Search for exceptions
```bash
grep -n "Exception" sample-logs/app.log
grep -n "NumberFormatException" sample-logs/app.log
grep -n "NullPointerException" sample-logs/app.log
```

### Search by class name
```bash
grep -n "ConfigService" sample-logs/app.log
grep -n "CustomerService" sample-logs/app.log
```

### Extract timestamps
```bash
awk '{print $1, $2}' sample-logs/app.log
```

### Count ERROR logs
```bash
grep "ERROR" sample-logs/app.log | wc -l
```

## PART 3 — Understand the Bugs

### NumberFormatException
`ConfigService.java` tries to parse:
```
"LIMIT_1000"
```
with:
```java
Integer.parseInt(raw);
```

### NullPointerException
`CustomerService.java` tries to process:
```
CUST-9999
```
which doesn’t exist → `customer` becomes `null`.

## PART 4 — Fix the Bugs

### Fix NumberFormatException
- Validate before parsing
- Use try/catch
- Replace invalid default

### Fix NullPointerException
- Check if customer exists
- Log and skip
- Throw a business exception

## PART 5 — Re-run

```bash
mvn compile
mvn exec:java
```

Expect:
- No exceptions
- Clean logs
- Successful completion

## PART 6 — Submit a Pull Request

Include:
- Issue summary
- Steps to reproduce
- Details of your fix
- Before/After logs
- Screenshots (optional)

## Optional Challenge
- Add validation for customer IDs
- Add limits to DAILY_LIMIT
- Add unit tests
