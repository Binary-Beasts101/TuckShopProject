package com.tuckshop.model;

import java.util.ArrayList;

public class InventoryManager {

    private ArrayList<Product> stockList;

    public InventoryManager() {

        this.stockList = new ArrayList<>();
    }

    public void registerNewProduct(Product item) {
        stockList.add(item);
        System.out.println("System Log: " + item.getName() + " has been added to the shop.");
    }

    public void showInventoryStatus() {
        System.out.println("\n--- TUCK SHOP CURRENT STOCK ---");
        for (Product item : stockList) {
            System.out.println("Product: " + item.getName() +
                    " | Quantity: " + item.getQuantity() +
                    " | Unit Price: P" + item.getPrice());

            if (item.getQuantity() < 5) {
                System.out.println("!!! ATTENTION: " + item.getName() + " is running low on stock.");
            }
        }
    }

    public void processSale(String nameOfItem, int amountSold) {
        for (Product item : stockList) {

            if (item.getName().equalsIgnoreCase(nameOfItem)) {
                if (item.getQuantity() >= amountSold) {

                    item.setQuantity(item.getQuantity() - amountSold);

                    double totalRevenue = item.getPrice() * amountSold;
                    System.out.println("Transaction Successful: p" + totalRevenue + " received.");
                    System.out.println("Updated stock level for " + nameOfItem + ": " + item.getQuantity());
                } else {
                    System.out.println("Transaction Failed: Insufficient stock for " + nameOfItem);
                }
                return;
            }
        }
        System.out.println("Error: Item not found in the inventory system.");
    }

    public void displayAllItems() {
        System.out.println("\n********************************");
        System.out.println("   --- UB TUCK SHOP SYSTEM ---  ");
        System.out.println("********************************");

        double subtotal = 0;

        for (Product p : stockList) {

            System.out.println("> " + p.getName() + " ........... P" + p.getPrice());
            subtotal += p.getPrice();
        }

        double discount = subtotal * 0.10; // 10% discount
        double finalTotal = subtotal - discount;

        System.out.println("--------------------------------");
        System.out.println("Subtotal: P" + subtotal);
        System.out.println("Student Discount (10%): -P" + discount);
        System.out.println("--------------------------------");
        System.out.println("Final Total: P" + finalTotal);
        System.out.println("********************************");
        System.out.println("  Have a great day loyal customer   ");

    }
}
