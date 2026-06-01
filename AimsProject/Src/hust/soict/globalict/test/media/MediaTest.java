package hust.soict.globalict.test.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.globalict.aims.exception.InvalidInputException;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;

public class MediaTest {
    public static void main(String[] args) {
        try {
            List<Media> mediae = new ArrayList<Media>();

            CompactDisc cd = new CompactDisc(1, "Frank Sinatra", "Music", "Various", "Frank Sinatra", 16.99);
            DigitalVideoDisc dvd = new DigitalVideoDisc("The Dark Knight", "Action", "Christopher Nolan", 152, 23.99);
            Book book = new Book(2, "How not to be wrong", "Math", 10.56);

            mediae.add(cd);
            mediae.add(dvd);
            mediae.add(book);

            for (Media m: mediae) {
                System.out.println(m.toString());
            }
        } catch (InvalidInputException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
