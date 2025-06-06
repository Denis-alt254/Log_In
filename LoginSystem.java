import java.io.IOException;
import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        final String correctUsername = "admin";
        final String correctPassword = "password123";

        Scanner scanner = new Scanner(System.in);
        int attempts = 3;

        while (attempts > 0) {
            System.out.print("Enter username: ");
            String inputUsername = scanner.nextLine();

            System.out.print("Enter password: ");
            String inputPassword = maskPassword();

            if (inputUsername.equals(correctUsername) && inputPassword.equals(correctPassword)) {
                System.out.println("\nLogin successful! Welcome, " + inputUsername + ".");
                scanner.close();
                return;
            } else {
                attempts--;
                System.out.println("\nIncorrect username or password. " + attempts + " tries left.");
            }
        }

        System.out.println("Too many failed attempts. Access denied.");
        scanner.close();
    }

    /*
     * Masks password input with '*' as the user types.
     */
    private static String maskPassword() {
        StringBuilder password = new StringBuilder();
        try {
            while (true) {
                char ch = (char) System.in.read(); 
                if (ch == '\n' || ch == '\r') {    
                    break;
                } else if (ch == '\b' || ch == 127) { 
                    if (password.length() > 0) {
                        password.deleteCharAt(password.length() - 1);
                        System.out.print("\b \b"); // Erase the last '*' from console
                    }
                } else {
                    password.append(ch);
                    System.out.print('*'); // Print '*' instead of the actual character
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return password.toString();
    }
}