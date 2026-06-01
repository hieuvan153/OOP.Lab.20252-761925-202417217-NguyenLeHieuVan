package hust.soict.globalict.test.disc;

import hust.soict.globalict.aims.exception.InvalidInputException;
import hust.soict.globalict.aims.media.DigitalVideoDisc;

public class TestPassingParameter {
	public static void main(String[] args) {
		try {
			DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
			DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

			swap(jungleDVD, cinderellaDVD);
			System.out.println("jungle dvd title: " + jungleDVD.getTitle());
			System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

			changeTitle(jungleDVD, cinderellaDVD.getTitle());
			System.out.println("jungle dvd title: " + jungleDVD.getTitle());
		} catch (InvalidInputException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public static void swap(Object o1, Object o2) {
		Object tmp = o1;
		o1 = o2;
		o2 = tmp;
	}

	public static void changeTitle(DigitalVideoDisc dvd, String title) throws InvalidInputException {
		String oldTitle = dvd.getTitle();
		dvd = new DigitalVideoDisc(oldTitle);
	}
}
