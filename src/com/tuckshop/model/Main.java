package com.tuckshop.model;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        InventoryManager myTuckShop = new InventoryManager();
        Scanner input = new Scanner(System.in);

        // Pre-loading the shop with items for the demo
        myTuckShop.registerNewProduct(new Product("P01", "Coke", 12.50, 10) {
            @Override
            public String getDisplayInfo() {
                return "Drink";
            }
        });
        myTuckShop.registerNewProduct(new Product("P02", "Chips", 8.00, 20) {
            @Override
            public String getDisplayInfo() {
                return "Snack";
            }
        });

        boolean active = true;

        // Loop keeps the system running until the user chooses 'Exit'
        while (active) {
            System.out.println("\n--- TUCK SHOP MANAGEMENT SYSTEM ---");
            System.out.println("1. View Stock  2. Sell Item  3. Exit");
            System.out.print("Choice: ");

            int choice = 0;

            // Safety check: prevent crash if user types letters instead of 1, 2, or 3
            try {
                choice = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("ERROR: Please enter a number (1, 2, or 3).");
                input.nextLine(); // Clear the "bad" input from memory
                continue; // Restart the menu loop
            }

            if (choice == 1) {
                // Displays current inventory and total revenue
                myTuckShop.displayReceipt();

            } else if (choice == 2) {
                System.out.print("Enter Product ID (e.g., P01): ");
                String id = input.next();

                System.out.print("Amount to sell: ");

                // Safety check: prevent crash if user types letters for the quantity
                try {
                    int qty = input.nextInt();
                    // This method handles the actual sale and stock deduction
                    myTuckShop.sellProduct(id, qty);
                } catch (InputMismatchException e) {
                    System.out.println("ERROR: Amount must be a whole number!");
                    input.nextLine(); // Clear the scanner buffer
                }

            } else if (choice == 3) {
                // Closes the loop and exits the program
                active = false;
                System.out.println("System Shutdown. Goodbye!");
            } else {
                // Handles numbers that aren't 1, 2, or 3
                System.out.println("Invalid choice. Please try again.");
            }
        }

        input.close(); // Closing scanner to prevent resource leaks
    }
}