package hust.soict.globalict.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
	private static int nbDigitalVideoDiscs = 0;
	
	public DigitalVideoDisc(String title) {
		super(++nbDigitalVideoDiscs, title, null, null, 0, 0.0);
	}
	public DigitalVideoDisc(String title, String category, double cost) {
		super(++nbDigitalVideoDiscs, title, category, null, 0, cost);
	}
	public DigitalVideoDisc(String title, String category, String director, double cost) {
		super(++nbDigitalVideoDiscs, title, category, director, 0, cost);
	}
	public DigitalVideoDisc(String title, String category, String director, int length, double cost) {
		super(++nbDigitalVideoDiscs, title, category, director, length, cost);
	}

	@Override
	public String toString() {
		return getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getLength() + ": " + getCost() + " $";
	}

	@Override
	public void play() {
		if (this.getLength() <= 0) {
			System.out.println("This DVD can't be played");
			return;
		} else {
			System.out.println("Playing DVD: " + this.getTitle());
			System.out.println("DVD Length: " + this.getLength());
		}
	}
}
