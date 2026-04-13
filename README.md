
# Bank Transfer Simulation using JDBC

A simple Java program that demonstrates **bank account transactions using JDBC**.  
It simulates transferring money between two accounts safely, using **transaction management** with `commit` and `rollback`.

---

## Features
- Deduct and add balance safely between accounts
- Manual transaction control using `setAutoCommit(false)`
- Rollback on exceptions to maintain data consistency
- Use of `PreparedStatement` to prevent SQL injection

---

## Database Setup

1. Create a database (e.g., `mydb`) in MySQL.
2. Create the `Bank` table:

```sql
CREATE TABLE Bank (
    AccountID INT PRIMARY KEY AUTO_INCREMENT,
    AccountHolderName VARCHAR(100),
    Balance DECIMAL(15,2)
);
````

3. Insert sample data:

```sql
INSERT INTO Bank (AccountHolderName, Balance) VALUES
('Alice', 5000.00),
('Bob', 10000.50),
('Charlie', 7500.25),
('David', 6000.00),
('Eve', 8000.00);
```

---

## How to Run

1. Ensure MySQL is running and database `mydb` exists.
2. Update the JDBC URL, username, and password in `Transaction.java`:

```java
Connection con = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/mydb",
    "root",
    "your_password"
);
```

3. Compile the program:

```bash
javac Transaction.java
```

4. Run the program:

```bash
java Transaction
```

5. Observe the console output:

* `Transaction Successful` → if the transfer succeeded
* `Rollback Done` → if there was an error during the transaction

> Tip: You can test rollback by uncommenting the line `int z = 5/0;` to simulate an error.

---

## Learning Outcomes

* Understanding JDBC transactions and rollback
* Writing safe database operations in Java
* Importance of atomic operations in financial applications

---




