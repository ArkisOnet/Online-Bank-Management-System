public class DatabaseSetup {
    public static void setupDatabase() {
        String createUsersTable = """
            CREATE TABLE IF NOT EXISTS Users (
                UserID SERIAL PRIMARY KEY,
                Name VARCHAR(100) NOT NULL,
                Email VARCHAR(100) UNIQUE NOT NULL,
                Password VARCHAR(255) NOT NULL,
                AccountType VARCHAR(20) NOT NULL
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

        String createTransactionsTable = """
            CREATE TABLE IF NOT EXISTS Transactions (
                TransactionID SERIAL PRIMARY KEY,
                AccountID INT NOT NULL REFERENCES Accounts(AccountID) ON DELETE CASCADE,
                Amount DECIMAL(15, 2) NOT NULL,
                TransactionType VARCHAR(20) CHECK (TransactionType IN ('Credit', 'Debit')),
                Timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP
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
    }
}
