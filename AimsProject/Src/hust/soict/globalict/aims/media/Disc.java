package hust.soict.globalict.aims.media;

public class Disc extends Media {
    private int length;
    private String director;

    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }

    public Disc() {
        super();
    }

    public Disc(int id, String title, String category, String director, int length, double cost) {
        super(id, title, category, cost);
        this.length = length;
        this.director = director;
    }
}
