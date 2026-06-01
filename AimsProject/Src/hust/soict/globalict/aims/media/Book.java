package hust.soict.globalict.aims.media;
import hust.soict.globalict.aims.exception.InvalidInputException;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();

    public Book() {
        super();
    }

    public Book(int id, String title, String category, double cost) throws InvalidInputException {
        super(id, title, category, cost);
    }

    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println("Author has been added: " + authorName);
        } else {
            System.out.println("Author " + authorName + " has existed");
        }
    }

    public void removeAuthor(String authorName) throws InvalidInputException {
        if (!authors.contains(authorName)) {
            throw new InvalidInputException("ERROR: Author \"" + authorName + "\" is not listed in this book");
        }
        authors.remove(authorName);
        System.out.println("Author has been removed: " + authorName);
    }

    @Override
    public String toString() {
        return "Book - " + getTitle() + " - " + getCategory() + " - " + authors + ": " + getCost() + " $";
    }
}
