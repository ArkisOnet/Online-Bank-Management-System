import java.sql.*;
class PremiumUser extends User {
    private double rewardPoints;

    public PremiumUser(int userId, String name, String email, double balance, double rewardPoints) {
        super(userId, name, email, balance);
        this.rewardPoints = rewardPoints;
    }

    public double getRewardPoints() {
        return rewardPoints;
    }

    public void setRewardPoints(double rewardPoints) {
        this.rewardPoints = rewardPoints;
    }

    @Override
    public void displayUserInfo() {
        System.out.printf("[Premium User] ID: %d, Name: %s, Email: %s, Balance: %.2f, Reward Points: %.2f%n",
                getUserId(), getName(), getEmail(), getBalance(), rewardPoints);
    }
}
