import java.sql.*;
public class UserDAO implements DatabaseOperations {
    @Override
    public void createUser(User user) {
        String sql = "INSERT INTO Users (Name, Email, Password, AccountType, Balance) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, "defaultPassword");
            stmt.setString(4, user instanceof PremiumUser ? "Premium" : "Regular");
            stmt.setDouble(5, user.getBalance());
            stmt.executeUpdate();
            System.out.println("User added successfully.");
        } catch (SQLException e) {
            System.err.println("Error creating user: " + e.getMessage());
        }
    }

    @Override
    public void readUsers() {
        String sql = "SELECT * FROM Users";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String accountType = rs.getString("AccountType");
                if ("Premium".equals(accountType)) {
                    User user = new PremiumUser(
                            rs.getInt("UserID"),
                            rs.getString("Name"),
                            rs.getString("Email"),
                            rs.getDouble("Balance"),
                            0.0
                    );
                    user.displayUserInfo();
                } else {
                    User user = new RegularUser(
                            rs.getInt("UserID"),
                            rs.getString("Name"),
                            rs.getString("Email"),
                            rs.getDouble("Balance")
                    );
                    user.displayUserInfo();
                }
            }
        } catch (SQLException e) {
            System.err.println("Error reading users: " + e.getMessage());
        }
    }

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
            } else {
                System.out.println("User not found.");
            }
        } catch (SQLException e) {
            System.err.println("Error updating user: " + e.getMessage());
        }
    }

    @Override
    public void deleteUser(int userId) {
        String sql = "DELETE FROM Users WHERE UserID = ?";
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
