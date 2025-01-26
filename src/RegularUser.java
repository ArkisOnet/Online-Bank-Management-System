import java.sql.*;
class RegularUser extends User {
    public RegularUser(int userId, String name, String email, double balance) {
        super(userId, name, email, balance);
    }

    @Override
    public void displayUserInfo() {
        System.out.printf("[Regular User] ID: %d, Name: %s, Email: %s, Balance: %.2f%n",
                getUserId(), getName(), getEmail(), getBalance());
    }
}