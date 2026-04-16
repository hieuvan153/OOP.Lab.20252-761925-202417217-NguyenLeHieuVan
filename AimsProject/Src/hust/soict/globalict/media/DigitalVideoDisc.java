package hust.soict.globalict.media;

public class DigitalVideoDisc extends Media {
	private String director;
	private int length;
	private static int nbDigitalVideoDiscs = 0;

	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	
	public DigitalVideoDisc(String title) {
		super(++nbDigitalVideoDiscs, title, null, 0.0);
	}
	public DigitalVideoDisc(String title, String category, double cost) {
		super(++nbDigitalVideoDiscs, title, category, cost);
	}
	public DigitalVideoDisc(String title, String category, String director, double cost) {
		super(++nbDigitalVideoDiscs, title, category, cost);
		this.director = director;
	}
	public DigitalVideoDisc(String title, String category, String director, int length, double cost) {
		super(++nbDigitalVideoDiscs, title, category, cost);
		this.director = director;
		this.length = length;
	}

	@Override
	public String toString() {
		return getTitle() + " - " + getCategory() + " - " + director + " - " + length + ": " + getCost() + " $";
	}

	public boolean isMatch(String searchTitle) {
		if (getTitle() == null || searchTitle == null) {
			return false;
		}
		return getTitle().equalsIgnoreCase(searchTitle);
	}
}
