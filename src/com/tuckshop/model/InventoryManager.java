/*
 * Author: Wayne Ashley
 * Task: Milestone 3 - Tuck Shop Management System
 * Description: Handles inventory storage, sales calculations, and stock display.
 */
package com.tuckshop.model;

import java.util.ArrayList;

public class InventoryManager {
    private ArrayList<Product> stockList;

    public InventoryManager() {
        this.stockList = new ArrayList<>();
    }

    public void registerNewProduct(Product item) {
        stockList.add(item);
    }

    public void sellProduct(String id, int amount) {
        for (Product item : stockList) {
            if (item.getId().equalsIgnoreCase(id)) {
                if (item.getQuantity() >= amount && amount > 0) {
                    item.setQuantity(item.getQuantity() - amount);
                    System.out.println("\n--- SALE SUCCESSFUL ---");
                    System.out.println("Sold: " + amount + " x " + item.getName());
                    System.out.println("Total: P" + (item.getPrice() * amount));
                } else {
                    System.out.println("\nERROR: Not enough stock!");
                }
                return;
            }
        }
        System.out.println("\nERROR: Product ID not found.");
    }

    public void displayReceipt() {
        System.out.println("\n===============================");
        System.out.println("       UB TUCK SHOP STOCK      ");
        System.out.println("===============================");
        for (Product item : stockList) {
            System.out.println(item.getId() + " | " + item.getName() +
                    " | P" + item.getPrice() +
                    " | Stock: " + item.getQuantity());
        }
        System.out.println("===============================");
    }
}