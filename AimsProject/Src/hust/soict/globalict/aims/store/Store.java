package hust.soict.globalict.aims.store;

import hust.soict.globalict.aims.exception.InvalidInputException;
import hust.soict.globalict.aims.exception.LimitExceededException;
import hust.soict.globalict.aims.media.Media;

import java.util.ArrayList;

public class Store {
    public static final int MAX_NUMBERS_IN_STORE = 100;
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public void addMedia(Media media) throws LimitExceededException {
        if (itemsInStore.size() >= MAX_NUMBERS_IN_STORE) {
            throw new LimitExceededException(
                    "ERROR: The store is full (" + MAX_NUMBERS_IN_STORE + " items max)");
        }
        itemsInStore.add(media);
        System.out.println("The media has been added");
        if (itemsInStore.size() == MAX_NUMBERS_IN_STORE) {
            System.out.println("The storage is now full");
        }
    }

    public void addMedia(Media... mediaList) throws LimitExceededException {
        for (Media media : mediaList) {
            this.addMedia(media);
        }
    }

    public void addMedia(Media media1, Media media2) throws LimitExceededException {
        this.addMedia(media1);
        this.addMedia(media2);
    }

    public void removeMedia(Media media) throws InvalidInputException {
        if (!itemsInStore.contains(media)) {
            throw new InvalidInputException(
                    "ERROR: Media \"" + media.getTitle() + "\" does not exist in the store");
        }
        itemsInStore.remove(media);
        System.out.println("The media has been removed");
    }

    public void removeMedia(Media... mediaList) throws InvalidInputException {
        for (Media media : mediaList) {
            this.removeMedia(media);
        }
    }

    public void removeMedia(Media media1, Media media2) throws InvalidInputException {
        this.removeMedia(media1);
        this.removeMedia(media2);
    }

    public Media searchByTitle(String title) {
        for (Media m : itemsInStore) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                return m;
            }
        }
        return null;
    }

    public void print() {
        System.out.println("Items in Store:");
        if (itemsInStore.isEmpty()) {
            System.out.println("The store is empty");
        } else {
            for (int i = 0; i < itemsInStore.size(); i++) {
                System.out.println((i + 1) + ". " + itemsInStore.get(i).toString());
            }
        }
    }

    public int getSize() {
        return itemsInStore.size();
    }

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
}
