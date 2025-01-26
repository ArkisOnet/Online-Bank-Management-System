<<<<<<< HEAD
import java.sql.Connection;
import java.sql.Statement;

=======
>>>>>>> 611b797a498a09dab03a123ab143a2213faed713
public class DatabaseSetup {
    public static void setupDatabase() {
        String createUsersTable = """
            CREATE TABLE IF NOT EXISTS Users (
<<<<<<< HEAD
                UserID SERIAL PRIMARY KEY,
                Name VARCHAR(100) NOT NULL,
                Email VARCHAR(100) UNIQUE NOT NULL,
                Password VARCHAR(255) NOT NULL,
                AccountType VARCHAR(20) NOT NULL,
                Balance DECIMAL(15, 2) DEFAULT 0.00,
                Reward_Points DECIMAL(15, 2) DEFAULT 0.00
            );
        """;

        String createAccountsTable = """
            CREATE TABLE IF NOT EXISTS Accounts (
                AccountID SERIAL PRIMARY KEY,
                UserID INT NOT NULL REFERENCES Users(UserID) ON DELETE CASCADE,
                Balance DECIMAL(15, 2) NOT NULL DEFAULT 0.00,
                AccountType VARCHAR(20) NOT NULL
            );
        """;

        String createLoansTable = """
            CREATE TABLE IF NOT EXISTS Loans (
                LoanID SERIAL PRIMARY KEY,
                UserID INT NOT NULL REFERENCES Users(UserID) ON DELETE CASCADE,
                LoanAmount DECIMAL(15, 2) NOT NULL,
                InterestRate DECIMAL(5, 2) NOT NULL,
                Status VARCHAR(20) CHECK (Status IN ('Pending', 'Approved', 'Rejected'))
            );
        """;

        String createCardsTable = """
            CREATE TABLE IF NOT EXISTS Cards (
                CardID SERIAL PRIMARY KEY,
                UserID INT NOT NULL REFERENCES Users(UserID) ON DELETE CASCADE,
                CardType VARCHAR(20) CHECK (CardType IN ('Credit', 'Debit')),
                ExpiryDate DATE NOT NULL
            );
        """;

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(createUsersTable);
            statement.executeUpdate(createAccountsTable);
            statement.executeUpdate(createLoansTable);
            statement.executeUpdate(createCardsTable);

            System.out.println("Таблицы успешно созданы или уже существуют.");
        } catch (Exception e) {
            System.err.println("Ошибка при создании базы данных: " + e.getMessage());
        }
    }
=======
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

>>>>>>> 611b797a498a09dab03a123ab143a2213faed713
}
