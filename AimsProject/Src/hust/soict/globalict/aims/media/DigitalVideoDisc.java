package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.exception.InvalidInputException;
import hust.soict.globalict.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {
	private static int nbDigitalVideoDiscs = 0;

	public DigitalVideoDisc(String title) throws InvalidInputException {
		super(++nbDigitalVideoDiscs, title, null, null, 0, 0.0);
	}
	public DigitalVideoDisc(String title, String category, double cost) throws InvalidInputException {
		super(++nbDigitalVideoDiscs, title, category, null, 0, cost);
	}
	public DigitalVideoDisc(String title, String category, String director, double cost) throws InvalidInputException {
		super(++nbDigitalVideoDiscs, title, category, director, 0, cost);
	}
	public DigitalVideoDisc(String title, String category, String director, int length, double cost) throws InvalidInputException {
		super(++nbDigitalVideoDiscs, title, category, director, length, cost);
	}

	@Override
	public String toString() {
		return getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getLength() + ": " + getCost() + " $";
	}

	@Override
	public void play() throws PlayerException {
		if (this.getLength() > 0) {
			System.out.println("Playing DVD: " + this.getTitle());
			System.out.println("DVD Length: " + this.getLength());
		} else {
			System.err.println("ERROR: DVD length is non-positive!");
			throw new PlayerException("ERROR: DVD length is non-positive!");
		}
	}
}
