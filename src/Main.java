import java.util.Scanner;
<<<<<<< HEAD
import java.sql.*;
=======
>>>>>>> 611b797a498a09dab03a123ab143a2213faed713

public class Main {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        Scanner scanner = new Scanner(System.in);
<<<<<<< HEAD
        DatabaseSetup.setupDatabase();

        while (true) {
            System.out.println("\n--- Online Bank Management System ---");
            System.out.println("1. Add Regular User");
            System.out.println("2. Add Premium User");
            System.out.println("3. View Users");
            System.out.println("4. Update User Email");
            System.out.println("5. Delete User");
            System.out.println("6. Exit");
=======

        while (true) {
            System.out.println("\n--- Online Bank Management System ---");
            System.out.println("1. Add User");
            System.out.println("2. View Users");
            System.out.println("3. Update User Balance");
            System.out.println("4. Delete User");
            System.out.println("5. Exit");
>>>>>>> 611b797a498a09dab03a123ab143a2213faed713
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter name: ");
                    String name = scanner.next();
                    System.out.print("Enter email: ");
                    String email = scanner.next();
<<<<<<< HEAD
                    System.out.print("Enter password: ");
                    String password = scanner.next();
                    System.out.print("Enter initial balance: ");
                    double balance = scanner.nextDouble();
                    User regularUser = new RegularUser(0, name, email, password, balance);
                    userDAO.createUser(regularUser);
                }
                case 2 -> {
                    System.out.print("Enter name: ");
                    String name = scanner.next();
                    System.out.print("Enter email: ");
                    String email = scanner.next();
                    System.out.print("Enter password: ");
                    String password = scanner.next();
                    System.out.print("Enter initial balance: ");
                    double balance = scanner.nextDouble();
                    System.out.print("Enter initial reward points: ");
                    double rewardPoints = scanner.nextDouble();
                    User premiumUser = new PremiumUser(0, name, email, password, balance, rewardPoints);
                    userDAO.createUser(premiumUser);
                }
                case 3 -> userDAO.readUsers();
                case 4 -> {
                    System.out.print("Enter user ID: ");
                    int userId = scanner.nextInt();
                    System.out.print("Enter new email: ");
                    String newEmail = scanner.next();
                    userDAO.updateUser(userId, "Email", newEmail);
                }
                case 5 -> {
=======
                    System.out.print("Enter initial balance: ");
                    double balance = scanner.nextDouble();
                    userDAO.createUser(name, email, balance);
                }
                case 2 -> userDAO.readUsers();
                case 3 -> {
                    System.out.print("Enter user ID: ");
                    int userId = scanner.nextInt();
                    System.out.print("Enter new balance: ");
                    double newBalance = scanner.nextDouble();
                    userDAO.updateUserBalance(userId, newBalance);
                }
                case 4 -> {
>>>>>>> 611b797a498a09dab03a123ab143a2213faed713
                    System.out.print("Enter user ID: ");
                    int userId = scanner.nextInt();
                    userDAO.deleteUser(userId);
                }
<<<<<<< HEAD
                case 6 -> {
=======
                case 5 -> {
>>>>>>> 611b797a498a09dab03a123ab143a2213faed713
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
