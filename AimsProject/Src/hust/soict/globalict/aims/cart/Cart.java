package hust.soict.globalict.aims.cart;
import hust.soict.globalict.aims.disc.DigitalVideoDisc;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered++;
			System.out.println("The disc has been added");
			
			if (qtyOrdered == MAX_NUMBERS_ORDERED) {
				System.out.println("The cart is almost full");
			} 
		} else {
			System.out.println("The cart is full");
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
		for (DigitalVideoDisc disc : dvdList) {
			this.addDigitalVideoDisc(disc);
		}
	}
	
	/*
	public void addDigitalVideoDisc(DigitalVideoDisc... dvdList) {
		for (DigitalVideoDisc disc : dvdList) {
			this.addDigitalVideoDisc(disc);
		}
	}
	*/
	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		this.addDigitalVideoDisc(dvd1);
		this.addDigitalVideoDisc(dvd2);
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		boolean found = false;
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i] == disc) {
				for (int j = i; j < qtyOrdered - 1; j++) {
					itemsOrdered[j] = itemsOrdered[j + 1];
				}
				itemsOrdered[qtyOrdered - 1] = null;
				qtyOrdered--;
				System.out.println("The disc has been removed");
				found = true;
				break;
			}
		}
		
		if (!found) {
			System.out.println("The disc was not found in the cart");
		}
	}

	public void print() {
		System.out.println("***********************************************CART***********************************************");
		System.out.println("Ordered Items:");
		for (int i = 0; i < qtyOrdered; i++) {
			System.out.println((i + 1) + ". DVD - " + itemsOrdered[i].toString());
		}
		System.out.println("Total cost: " + totalCost() + " $");
		System.out.println("**************************************************************************************************");
	}
	
	public double totalCost() {
		double res = 0.0;
		for (int i = 0; i < qtyOrdered; i++) {
			res += itemsOrdered[i].getCost();
		}
		return res;
	}

	public void searchByID(int id) {
		boolean found = false;
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].getId() == id) {
				found = true;
				System.out.println(id + ". DVD - " + itemsOrdered[i].toString());
			}
		}
		if (!found) {
			System.out.println("The disc was not found in the cart");
		}
	}

	public void searchByTitle(String searchTitle) {
		boolean found = false;
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].isMatch(searchTitle)) {
				found = true;
				System.out.println("DVD - " + itemsOrdered[i].toString());
			}
		}
		if (!found) {
			System.out.println("The disc was not found in the cart");
		}
	}
}
