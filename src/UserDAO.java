import java.sql.*;

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
        } catch (SQLException e) {
            System.err.println("Error creating user: " + e.getMessage());
        }
    }

    public void readUsers() {
        String sql = "SELECT * FROM Users";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.printf("ID: %d, Name: %s, Email: %s, Balance: %.2f%n",
                        rs.getInt("id"), rs.getString("name"),
                        rs.getString("email"), rs.getDouble("balance"));
            }
        } catch (SQLException e) {
            System.err.println("Error reading users: " + e.getMessage());
        }
    }

    public void updateUserBalance(int userId, double newBalance) {
        String sql = "UPDATE Users SET balance = 500 WHERE id = 1";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, newBalance);
            stmt.setInt(2, userId);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Balance updated successfully.");
            } else {
                System.out.println("User not found.");
            }
        } catch (SQLException e) {
            System.err.println("Error updating balance: " + e.getMessage());
        }
    }

    public void deleteUser(int userId) {
        String sql = "DELETE FROM Users WHERE id = ?";
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
