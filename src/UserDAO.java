import java.sql.*;
<<<<<<< HEAD
public class UserDAO implements DatabaseOperations {
    @Override
    public void createUser(User user) {
        String sql = "INSERT INTO Users (Name, Email, Password, AccountType, Balance, Reward_Points) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user instanceof PremiumUser ? "Premium" : "Regular");
            stmt.setDouble(5, user.getBalance());
            stmt.setDouble(6, user.getRewardPoints());

            stmt.executeUpdate();
            System.out.printf("User added successfully.");
=======

public class UserDAO {
    public void createUser(String name, String email, double balance) {
        String sql = "INSERT INTO Users (name, email, balance) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setDouble(3, balance);
            stmt.executeUpdate();
            System.out.println("User added successfully.");
>>>>>>> 611b797a498a09dab03a123ab143a2213faed713
        } catch (SQLException e) {
            System.err.println("Error creating user: " + e.getMessage());
        }
    }

<<<<<<< HEAD
    @Override
=======
>>>>>>> 611b797a498a09dab03a123ab143a2213faed713
    public void readUsers() {
        String sql = "SELECT * FROM Users";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
<<<<<<< HEAD
                String accountType = rs.getString("AccountType");
                if ("Premium".equals(accountType)) {
                    User user = new PremiumUser(
                            rs.getInt("UserID"),
                            rs.getString("Name"),
                            rs.getString("Email"),
                            rs.getString("Password"),
                            rs.getDouble("Balance"),
                            rs.getDouble("Reward_Points")
                    );
                    user.displayUserInfo();
                } else {
                    User user = new RegularUser(
                            rs.getInt("UserID"),
                            rs.getString("Name"),
                            rs.getString("Email"),
                            rs.getString("Password"),
                            rs.getDouble("Balance")
                    );
                    user.displayUserInfo();
                }
=======
                System.out.printf("ID: %d, Name: %s, Email: %s, Balance: %.2f%n",
                        rs.getInt("id"), rs.getString("name"),
                        rs.getString("email"), rs.getDouble("balance"));
>>>>>>> 611b797a498a09dab03a123ab143a2213faed713
            }
        } catch (SQLException e) {
            System.err.println("Error reading users: " + e.getMessage());
        }
    }

<<<<<<< HEAD
    @Override
    public void updateUser(int userId, String columnName, Object newValue) {
        String sql = "UPDATE Users SET " + columnName + " = ? WHERE UserID = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setObject(1, newValue);
            stmt.setInt(2, userId);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("User updated successfully.");
=======
    public void updateUserBalance(int userId, double newBalance) {
        String sql = "UPDATE Users SET balance = 500 WHERE id = 1";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, newBalance);
            stmt.setInt(2, userId);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Balance updated successfully.");
>>>>>>> 611b797a498a09dab03a123ab143a2213faed713
            } else {
                System.out.println("User not found.");
            }
        } catch (SQLException e) {
<<<<<<< HEAD
            System.err.println("Error updating user: " + e.getMessage());
        }
    }

    @Override
    public void deleteUser(int userId) {
        String sql = "DELETE FROM Users WHERE UserID = ?";
=======
            System.err.println("Error updating balance: " + e.getMessage());
        }
    }

    public void deleteUser(int userId) {
        String sql = "DELETE FROM Users WHERE id = ?";
>>>>>>> 611b797a498a09dab03a123ab143a2213faed713
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("User deleted successfully.");
            } else {
                System.out.println("User not found.");
            }
        } catch (SQLException e) {
            System.err.println("Error deleting user: " + e.getMessage());
        }
    }
}
