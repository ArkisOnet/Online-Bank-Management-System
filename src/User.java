import java.sql.*;
abstract class User {
    private int userId;
    private String name;
    private String email;
    private String password;
    private double balance;


    public User(int userId, String name, String email,String password ,double balance) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = balance;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPassword(){
        return password;
    }

    abstract public boolean isPrem();
    abstract public double getRewardPoints();

    public abstract void displayUserInfo();
}