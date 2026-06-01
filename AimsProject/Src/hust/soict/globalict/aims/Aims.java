package hust.soict.globalict.aims;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.exception.InvalidInputException;
import hust.soict.globalict.aims.exception.LimitExceededException;
import hust.soict.globalict.aims.media.*;
import hust.soict.globalict.aims.screen.customer.controller.ViewStoreController;
import hust.soict.globalict.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Aims extends Application {

    private static Store store = new Store();
    private static Cart cart = new Cart();

    @Override
    public void start(Stage primaryStage) throws Exception {
        final String STORE_FXML = "/hust/soict/globalict/aims/screen/customer/view/Store.fxml";
        FXMLLoader loader = new FXMLLoader(getClass().getResource(STORE_FXML));
        loader.setController(new ViewStoreController(store, cart));
        Parent root = loader.load();

        primaryStage.setTitle("AIMS");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        testData();
        launch(args);
    }

    public static void testData() {
        try {
            store.addMedia(new DigitalVideoDisc("The Dark Knight", "Action", "Christopher Nolan", 152, 23.99));
            store.addMedia(new DigitalVideoDisc("Avatar", "Science Fiction", "James Cameron", 162, 29.50));
            store.addMedia(new DigitalVideoDisc("Jurassic Park", "Science Fiction", "Steven Spielberg", 127, 21.99));
            store.addMedia(new DigitalVideoDisc("Finding Nemo", "Animation", 16.99));
            store.addMedia(new DigitalVideoDisc("Harry Potter and the Philosopher's Stone", "Fantasy", "Chris Columbus", 152, 3.0));
            store.addMedia(new DigitalVideoDisc("Harry Potter and the Chamber of Secrets", "Fantasy", "Chris Columbus", 161, 3.5));
            store.addMedia(new DigitalVideoDisc("Harry Potter and the Prisoner of Azkaban", "Fantasy", "Alfonso Cuaron", 141, 5.0));
            store.addMedia(new DigitalVideoDisc("Harry Potter and the Goblet of Fire", "Fantasy", "Mike Newell", 157, 4.5));

            CompactDisc cd = new CompactDisc(1, "Frank Sinatra: Greatest Hits", "Music", "Various", "Frank Sinatra", 12.99);
            cd.addTrack(new Track("Fly Me to The Moon", 148));
            cd.addTrack(new Track("My Way", 273));
            cd.addTrack(new Track("Jingle Bells", 121));
            store.addMedia(cd);

            store.addMedia(new Book(1, "How not to be wrong", "Math", 10.56));
            store.addMedia(new Book(2, "The Hunger Games", "Young Adult", 5.5));
            store.addMedia(new Book(3, "Catching Fire", "Young Adult", 4.9));
        } catch (InvalidInputException | LimitExceededException e) {
            System.out.println("Error loading test data: " + e.getMessage());
        }
    }
}
