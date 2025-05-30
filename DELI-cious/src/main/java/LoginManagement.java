import java.io.*;
import java.util.Scanner;

public class LoginManagement {
    static Scanner scanner = new Scanner(System.in);

    public static void signUp() {

        boolean input = false;
        boolean input1 = false;

        // Initialize variables for email parts and user input
        String[] parts = new String[0];
        String email = "";

        System.out.println("Select an option:");
        System.out.println("Enter your first name:");
        String firstName = scanner.nextLine();

        System.out.println("Enter your last name:");
        String lastName = scanner.nextLine();

        while (!input) {
            System.out.println("Enter your Email:");
            email = scanner.nextLine();

            // Split the email into parts based on '@' and '.' characters
            parts = email.trim().split("[@.]");

            if (parts.length > 2) {
                input = true; // Email is valid, exit the loop
            } else {
                System.out.println("Invalid email address");
            }
        }

        while (!input1) {
            System.out.println("Enter a password (at least 4 characters)");
            String password = scanner.nextLine();

            // Create file name based on the email username (before '@')
            String file = parts[0] + ".csv";

            // Check if password length is at least 4 characters
            if (password.length() > 3) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                    writer.write(email + "," + password);
                    writer.newLine();

                    // Show success message
                    System.out.println();
                    System.out.println("✅ Sign-up successful! Welcome, " + firstName + " " + lastName + "!");
                    input1 = true;
                } catch (IOException e) {
                    System.out.println("Error saving user info.");
                }
            } else {
                System.out.println("Error: Password must be at least 4 character.");
            }
        }
    }

    public static boolean signInCheck() {

        boolean input = false;
        boolean discount = false;

        while (!input) {

            System.out.println("*****DELI-cious*****");
            System.out.println("\nEnter your Email");
            String email = scanner.nextLine();

            System.out.println("Enter your password");
            String password = scanner.nextLine();

            // Split the email into parts
            String[] parts = email.trim().split("[@.]");
            File file = new File(parts[0] + ".csv");

            if (file.exists()) {
                discount = true;
                input = true;
            } else {
                System.out.println("Incorrect user name or password");
            }
        }

        return discount;
    }
}


