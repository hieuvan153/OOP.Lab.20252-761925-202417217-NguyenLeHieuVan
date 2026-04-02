
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
	
	public double totalCost() {
		double res = 0.0;
		for (int i = 0; i < qtyOrdered; i++) {
			res += itemsOrdered[i].getCost();
		}
		return res;
	}
}
