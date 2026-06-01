package hust.soict.globalict.test.cart;
import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.exception.InvalidInputException;
import hust.soict.globalict.aims.exception.LimitExceededException;
import hust.soict.globalict.aims.media.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        try {
            Cart cart = new Cart();
            DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95);
            cart.addMedia(dvd1);
            DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95);
            cart.addMedia(dvd2);
            DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99);
            cart.addMedia(dvd3);

            cart.print();
            cart.searchByID(2);
            cart.searchByID(5);
            System.out.println(cart.searchByTitle("Star Wars"));
            System.out.println(cart.searchByTitle("Titanic"));
            System.out.println(cart.searchByTitle("Unknown"));
        } catch (InvalidInputException | LimitExceededException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
