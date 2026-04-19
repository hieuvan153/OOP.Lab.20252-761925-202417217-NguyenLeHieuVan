package hust.soict.globalict.aims.cart;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.MediaComparatorByCostTitle;

import java.util.ArrayList;
import java.util.Collections;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

	public void addMedia(Media media) {
		if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is full");
		} else if (itemsOrdered.contains(media)) {
			System.out.println("The media has already been added");
		} else {
			itemsOrdered.add(media);
		}
	}

	public void removeMedia(Media media) {
		if (!itemsOrdered.contains(media)) {
			System.out.println("The media is not in the cart");
		} else {
			itemsOrdered.remove(media);
			System.out.println("The media is successfully removed");
		}
	}

	public void print() {
		System.out.println("***********************************************CART***********************************************");
		System.out.println("Ordered Items:");
		for (int i = 0; i < itemsOrdered.size(); i++) {
			System.out.println((i + 1) + ". Media - " + itemsOrdered.get(i).toString());
		}
		System.out.println("Total cost: " + totalCost() + " $");
		System.out.println("**************************************************************************************************");
	}
	
	public double totalCost() {
		double res = 0.0;
		for (Media media : itemsOrdered) {
			res += media.getCost();
		}
		return res;
	}

	public void searchByID(int id) {
		boolean found = false;
		for (Media media : itemsOrdered) {
			if (media.getId() == id) {
				found = true;
				System.out.println(id + ". Media - " + media.toString());
			}
		}
		if (!found) {
			System.out.println("The media was not found in the cart");
		}
	}

	public Media searchByTitle(String title) {
		for (Media m: itemsOrdered) {
			if (m.getTitle().equalsIgnoreCase(title)) {
				return m;
			}
		}
		return null;
	}

	public void sortByCost() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
	}

	public void sortByTitle() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
	}

	public int getSize() {
		return itemsOrdered.size();
	}
}
