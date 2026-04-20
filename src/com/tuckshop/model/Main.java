package com.tuckshop.model;

public class Main {
    public static void main(String[] args) {
        InventoryManager myTuckShop = new InventoryManager();

        Product item1 = new Product("P01", "Coke", 12.50, 10) {
            @Override
            public String getDisplayInfo() {
                return "Drink: " + getName();
            }
        };

        Product item2 = new Product("P02", "Chips", 8.00, 20) {
            @Override
            public String getDisplayInfo() {
                return "Snack: " + getName();
            }
        };

        Product item3 = new Product("P03", "Biscuits", 5.50, 15) {
            @Override
            public String getDisplayInfo() {
                return "Snack: " + getName();
            }
        };

        myTuckShop.registerNewProduct(item1);
        myTuckShop.registerNewProduct(item2);
        myTuckShop.registerNewProduct(item3);

        myTuckShop.displayAllItems();

        System.out.println("\nSuccess! System is stable.");
    }
}