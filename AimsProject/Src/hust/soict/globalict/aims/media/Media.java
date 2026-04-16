package hust.soict.globalict.aims.media;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private double cost;

    public Media() {
        super();
    }

    public Media(int id, String title, String category, double cost) {
        super();
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getCategory() {
        return category;
    }
    public double getCost() {
        return cost;
    }
}
