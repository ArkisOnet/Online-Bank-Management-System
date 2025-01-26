import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLEoxception;
public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/oop";
    private static final String USER = "postgres";
    private static final String PASSWORD = "admin";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/oop", "postgres", "admin");
    }

}
