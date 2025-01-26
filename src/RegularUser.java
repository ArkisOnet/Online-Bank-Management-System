import java.sql.*;
class RegularUser extends User {
    public RegularUser(int userId, String name, String email, String password, double balance) {
        super(userId, name, email, password, balance);
    }
    public boolean isPrem(){
        return false;
    }

    public double getRewardPoints(){
        return 0.00;
    }
    @Override
    public void displayUserInfo() {
        System.out.printf("[Regular User] ID: %d, Name: %s, Email: %s, Password: %s, Balance: %.2f%n",
                getUserId(), getName(), getEmail(), getPassword(), getBalance());
    }
}