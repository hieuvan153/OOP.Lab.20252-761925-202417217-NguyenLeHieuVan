package hust.soict.globalict.aims.store;
import hust.soict.globalict.aims.disc.DigitalVideoDisc;

public class Store {
    public static final int MAX_NUMBERS_IN_STORE = 100;
    private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX_NUMBERS_IN_STORE];
    private int qtyInStore = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyInStore < MAX_NUMBERS_IN_STORE) {
            itemsInStore[qtyInStore] = disc;
            qtyInStore++;
            System.out.println("The disc has been added");

            if (qtyInStore == MAX_NUMBERS_IN_STORE) {
                System.out.println("The store is almost out of storage");
            }
        } else {
            System.out.println("The store is out of storage");
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc ... dvdList) {
        for (DigitalVideoDisc disc : dvdList) {
            this.addDigitalVideoDisc(disc);
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        this.addDigitalVideoDisc(dvd1);
        this.addDigitalVideoDisc(dvd2);
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        boolean found = false;
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i].equals(disc)) {
                for (int j = i; j < qtyInStore - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[qtyInStore - 1] = null;
                qtyInStore--;
                System.out.println("The disc has been removed from storage");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("The disc was not found in the store");
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc ... dvdList) {
        for (DigitalVideoDisc disc : dvdList) {
            this.removeDigitalVideoDisc(disc);
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        this.removeDigitalVideoDisc(dvd1);
        this.removeDigitalVideoDisc(dvd2);
    }
}
