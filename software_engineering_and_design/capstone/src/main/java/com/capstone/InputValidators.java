package com.capstone;
import java.util.Scanner;

public class InputValidators {

    static Scanner scanner = new Scanner(System.in);

    public static String validateUsername() {
        int MIN_CHARS = 4;
        int MAX_CHARS = 20;

        String username = scanner.nextLine();
        while (username.length() < MIN_CHARS || username.length() > MAX_CHARS) {
            System.out.println("Username must be between " + MIN_CHARS + " and " + MAX_CHARS + " characters long.");
            username = scanner.nextLine();
        }
        return username;
    }

    public static String validatePassword() {
        int MIN_CHARS = 8;
        int MAX_CHARS = 20;

        String password = scanner.nextLine();
        while (password.length() < MIN_CHARS || password.length() > MAX_CHARS) {
            System.out.println("Password must be between " + MIN_CHARS + " and " + MAX_CHARS + " characters long.");
            password = scanner.nextLine();
        }
        return password;
    }

    public static int validateNumericInput() {
        int input = 0;
        while (true) {
            try {
                input = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        return input;
    }

}
