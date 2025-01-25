public class DatabaseSetup {
    public static void setupDatabase() {
        String createUsersTable = """
            CREATE TABLE IF NOT EXISTS Users (
                id SERIAL PRIMARY KEY,
                name VARCHAR(100) NOT NULL,
                email VARCHAR(100) UNIQUE NOT NULL,
                balance NUMERIC(10, 2) NOT NULL,
                isPremium BOOLEAN NOT NULL
            );
        """;
        String createTransactionsTable = """
            CREATE TABLE IF NOT EXISTS Transactions (
                id SERIAL PRIMARY KEY,
                userId INT NOT NULL REFERENCES Users(id),
                transactionType VARCHAR(10) NOT NULL,
                amount NUMERIC(10, 2) NOT NULL,
                transactionDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP
            );
        """;
    }

}
