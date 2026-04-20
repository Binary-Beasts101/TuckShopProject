package com.tuckshop.model;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InventoryManager myTuckShop = new InventoryManager();
        Scanner input = new Scanner(System.in);

        // Pre-load the shop with items
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
        while (active) {
            System.out.println("\n1. View Stock  2. Sell Item  3. Exit");
            System.out.print("Choice: ");
            int choice = input.nextInt();

            if (choice == 1) {
                myTuckShop.displayReceipt();
            } else if (choice == 2) {
                System.out.print("Enter ID: ");
                String id = input.next();
                System.out.print("Amount: ");
                int qty = input.nextInt();
                myTuckShop.sellProduct(id, qty);
            } else if (choice == 3) {
                active = false;
                System.out.println("System Shutdown.");
            }
        }
        input.close();
    }
}