package com.keyChainShop;

import java.util.Scanner;

public class Keychain {

	Scanner scn = new Scanner(System.in);
	private double pricePerKey = 10.00;
	private double salesTax = 8.25;
	private double shipPerOrder = 5.00;
	public int numberOfKey = 0;
	public int choice = 0;

	public Keychain() {

		System.out.println("WELCOME TO KEYCHAIN SHOP");
		printChoice();

		while (choice != 4) {

			if (choice == 1) {
				this.numberOfKey = addKeychains(numberOfKey);
				printChoice();
			} else if (choice == 2) {
				this.numberOfKey = removeKeychains(numberOfKey);
				printChoice();
			} else if (choice == 3) {
				viewOrder(numberOfKey, pricePerKey, salesTax, shipPerOrder);
				printChoice();
			} else {
				System.out.println(("Error! Enter a valid number").toUpperCase());
				printChoice();
			}

		}

		checkout(numberOfKey, pricePerKey, salesTax, shipPerOrder);
	}

	private int addKeychains(int num) {
		System.out.println("ADD KEYCHAINS");
		System.out.print("\nYou have " + num + " keychains. How many to add: ");
		int add = scn.nextInt();
		num += add;
		System.out.println("You have " + num + " keychains now");

		return num;
	}

	private int removeKeychains(int num) {
		System.out.println("REMOVE KEYCHAINS");
		System.out.print("\nYou have " + num + " keychains. How many to remove: ");
		int remove = scn.nextInt();
	
		while (remove > num) {
			System.out.print("NUMBER CAN'T BE NEGATIVE. PLEASE TRY AGAIN ");
			remove = scn.nextInt();
		}
		num -= remove;
		System.out.println("You have " + num + " keychains now");

		return num;

	}

	private void viewOrder(int num, double price, double tax, double shipOrder) {
		System.out.println("VIEW ORDER");
		System.out.println("\nYou have " + num + " keychains");
		System.out.println("Keychains cost $" + price + " each");
		System.out.println("Sales tax: " + tax + "%");
		System.out.println("Shipping: " + shipOrder);
		System.out.println("Your total is $" + ((price * num) +(num * price * (tax/100) + shipOrder)));
	}

	private void checkout(int num, double price, double tax, double shipOrder) {
		System.out.println("CHECKOUT");
		System.out.print("\nWhat is your name: ");
		String name = scn.next();
		System.out.println("\nYou have " + num + " keychains");
		System.out.println("Keychains cost $" + price + " each");
		System.out.println("Sales tax: " + tax + "%");
		System.out.println("Shipping: " + shipOrder);
		System.out.println("Your total is $" + ((price * num) +  (num * price * (tax/100) + shipOrder)));
		System.out.println("Thank for your order, " + name);

	}

	private void printChoice() {
		System.out.println("\n1. Add Keychains to Order");
		System.out.println("2. Remove Keychains from Order");
		System.out.println("3. View current Order");
		System.out.println("4. Checkout");
		System.out.print("\nPlease enter your choice: ");
		choice = scn.nextInt();
	}
	
	public void setPrice(double price) {this.pricePerKey = price;}
	public void setShipping(double shipOrder) {this.shipPerOrder = shipOrder;}
	public void setTax(double tax) {this.salesTax = tax;}
	
	public double getPrice() {return pricePerKey;}
	public double getShipping() {return shipPerOrder;}
	public double getTax() {return salesTax;}
}
