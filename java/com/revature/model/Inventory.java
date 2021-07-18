//package com.revature.model;
//
//import java.util.ArrayList;
//
//public class Inventory {
//
//
//    public Inventory() {
//         new Item("Standard Cash Envelope", 3.00));
//        this.item.add(new Item("Mini Cash Envelope", 2.50));
//    }
//
//    public void increaseQuantity(String itemName) {
//        for (Item item : this.items) {
//            if (itemName.equals(item.getName())) {
//                item.add();
//                return;
//            }
//        }
//    }
//
//    public void decreaseQuantity(String itemName) {
//        for (Item item : this.items) {
//            if (itemName.equals(item.getName())) {
//                if (item.getQuantity()>=0) {
//                    item.remove();
//                }
//                return;
//            }
//        }
//    }
//
//
//    public void createItem(String name, String itemId) {
//        this.items.add(new Item(name,itemId));
//    }
//
//    public String toString() {
//        String s="";
//        s+="Inventory contains:\n";
//        for (Item item:this.items) {
//            s+='\t'+item.toString();
//        }
//        return s;
//    }
//
//
//    public void printInventory() {
//        System.out.println(this.toString());
//    }
//
//
//}
