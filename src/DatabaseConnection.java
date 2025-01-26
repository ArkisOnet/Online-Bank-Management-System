import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DatabaseConnection {
<<<<<<< HEAD
    private static final String URL = "jdbc:postgresql://localhost:5432/oop";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1234";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/oop", "postgres", "1234");
=======
    private static final String URL = "jdbc:postgresql://localhost:5432/postrges2";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1234"; //Replace with your PostgreSQL password.

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postrges2", "postgres", "1234");
>>>>>>> 611b797a498a09dab03a123ab143a2213faed713
    }

}
