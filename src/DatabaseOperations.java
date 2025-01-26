import java.sql.*;
public interface DatabaseOperations {
    void createUser(User user);

    void readUsers();

    void updateUser(int userId, String columnName, Object newValue);

    void deleteUser(int userId);
}