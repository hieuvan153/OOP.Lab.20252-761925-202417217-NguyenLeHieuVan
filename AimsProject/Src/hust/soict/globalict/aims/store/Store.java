package hust.soict.globalict.aims.store;
import hust.soict.globalict.aims.media.Media;

import java.util.ArrayList;

public class Store {
    public static final int MAX_NUMBERS_IN_STORE = 100;
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public void addMedia(Media media) {
        if (itemsInStore.size() < MAX_NUMBERS_IN_STORE) {
            itemsInStore.add(media);
            System.out.println("The media has been added");

            if (itemsInStore.size() == MAX_NUMBERS_IN_STORE) {
                System.out.println("The storage is almost full");
            }
        } else {
            System.out.println("The storage is full");
        }
    }

    public void addMedia(Media... mediaList) {
        for (Media media : mediaList) {
            this.addMedia(media);
        }
    }

    public void addMedia(Media media1, Media media2) {
        this.addMedia(media1);
        this.addMedia(media2);
    }

    public void removeMedia(Media media) {
        if (!itemsInStore.contains(media)) {
            System.out.println("The media does not exist");
        } else {
            itemsInStore.remove(media);
            System.out.println("The media has been removed");
        }
    }

    public void removeMedia(Media... mediaList) {
        for (Media media : mediaList) {
            this.removeMedia(media);
        }
    }

    public void removeMedia(Media media1, Media media2) {
        this.removeMedia(media1);
        this.removeMedia(media2);
    }
}
