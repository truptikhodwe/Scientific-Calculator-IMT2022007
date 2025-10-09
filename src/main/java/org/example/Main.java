package org.example;
import java.util.Scanner;

public class Main {
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//
//        System.out.println("Calculator app is ready. Press Enter to continue...");
//        sc.nextLine();
//
//        while (true){
//            System.out.println("Scientific Calculator Menu");
//            System.out.println("1. Square Root (√x)");
//            System.out.println("2. Factorial (x!)");
//            System.out.println("3. Natural Logarithm (ln(x))");
//            System.out.println("4. Power (x^b)");
//            System.out.println("5. Exit");
//            System.out.print("Enter your choice (1-5): ");
//
////            int choice = sc.nextInt();
////            double x, b;
//
//            int choice;
//            try {
//                choice = sc.nextInt();
//            } catch (java.util.InputMismatchException e) {
//                System.out.println("Error: Invalid input. Please enter a number.");
//                sc.next(); // IMPORTANT: This clears the bad input from the scanner.
//                continue;  // Skip the rest of the loop and show the menu again.
//            }
//
//            double x, b;
//
//            switch (choice){
//                case 1:
//                    System.out.println("Enter number (x):");
//                    x = sc.nextDouble();
//                    try{
//                        double result = Operations.squareRoot(x);
//                        System.out.println("Output: " + result);
//                    }
//                    catch (IllegalArgumentException e){
//                        System.out.println("Error: " + e.getMessage());
//                    }
//                    break;
//
//                case 2:
//                    System.out.println("Enter number (x): ");
//                    x = sc.nextDouble();
//
//                    try{
//                        double result = Operations.factorial(x);
//                        System.out.println("Output: " + result);
//                    }
//                    catch (IllegalArgumentException e){
//                        System.out.println("Error: " + e.getMessage());
//                    }
//                    break;
//
//                case 3:
//                    System.out.println("Enter number (x): ");
//                    x = sc.nextDouble();
//
//                    try{
//                        double result = Operations.log(x);
//                        System.out.println("Output: " + result);
//                    }
//                    catch (IllegalArgumentException e){
//                        System.out.println("Error: " + e.getMessage());
//                    }
//                    break;
//
//                case 4:
//                    System.out.println("Enter base (x): ");
//                    x = sc.nextDouble();
//                    System.out.println("Enter exponent (b): ");
//                    b = sc.nextDouble();
//
//                    try{
//                        double result = Operations.pow(x, b);
//                        System.out.println("Output: " + result);
//                    }
//                    catch (IllegalArgumentException e){
//                        System.out.println("Error: " + e.getMessage());
//                    }
//                    break;
//
//                case 5:
//                    System.out.println("Thanks for visiting!");
//                    return;
//
//                default:
//                    System.out.println("Invalid choice, try again!");
//            }
//
//        }
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. The program now waits here after starting.
        // When you attach and press Enter, the main loop begins.
        System.out.println("Calculator is ready. Attach and press Enter to begin.");
        sc.nextLine();

        while (true) {
            System.out.println("\n----- Scientific Calculator Menu -----");
            System.out.println("1. Square Root (√x)");
            System.out.println("2. Factorial (x!)");
            System.out.println("3. Natural Logarithm (ln(x))");
            System.out.println("4. Power (x^b)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");

            int choice;
            try {
                // 2. We read the menu choice safely inside the loop.
                choice = sc.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Error: Invalid input. Please enter a whole number.");
                sc.next(); // Clear the bad input
                continue;  // Restart the loop and show the menu again
            }

            double x, b;

            switch (choice) {
                case 1:
                    System.out.print("Enter number (x): ");
                    try {
                        x = sc.nextDouble();
                        double result = Operations.squareRoot(x);
                        System.out.println("Output: " + result);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Error: Invalid input. Please enter a number.");
                    }
                    break;

                case 2:
                    System.out.print("Enter a non-negative integer (x): ");
                    try {
                        int num = sc.nextInt();
                        double result = Operations.factorial(num);
                        System.out.println("Output: " + result);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Error: Invalid input. Please enter a whole number.");
                    }
                    break;

                case 3:
                    System.out.print("Enter number (x): ");
                    try {
                        x = sc.nextDouble();
                        double result = Operations.log(x);
                        System.out.println("Output: " + result);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Error: Invalid input. Please enter a number.");
                    }
                    break;

                case 4:
                    try {
                        System.out.print("Enter base (x): ");
                        x = sc.nextDouble();
                        System.out.print("Enter exponent (b): ");
                        b = sc.nextDouble();
                        double result = Operations.pow(x, b);
                        System.out.println("Output: " + result);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Error: Invalid input. Please enter numbers.");
                    }
                    break;

                case 5:
                    System.out.println("Thanks for visiting!");
                    return; // Exit the program

                default:
                    System.out.println("Invalid choice, try again!");
            }

            // 3. This is a small but important fix to prevent scanner issues on the next loop.
            sc.nextLine();
        }
    }
}