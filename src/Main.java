import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Online Bank Management System ---");
            System.out.println("1. Add User");
            System.out.println("2. View Users");
            System.out.println("3. Update User Balance");
            System.out.println("4. Delete User");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter name: ");
                    String name = scanner.next();
                    System.out.print("Enter email: ");
                    String email = scanner.next();
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
                    System.out.print("Enter user ID: ");
                    int userId = scanner.nextInt();
                    userDAO.deleteUser(userId);
                }
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
