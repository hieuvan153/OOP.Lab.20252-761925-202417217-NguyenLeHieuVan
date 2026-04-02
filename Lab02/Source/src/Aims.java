
public class Aims {
	public static void main(String[] args) {
		Cart anOrder = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		anOrder.addDigitalVideoDisc(dvd1);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Satr Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		anOrder.addDigitalVideoDisc(dvd2);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		anOrder.addDigitalVideoDisc(dvd3);
		
		System.out.println("Total Cost is: ");
		System.out.printf("%.2f", anOrder.totalCost());
		System.out.println("");
		
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("The Matrix", "Science Fiction", "Lana Wachowski", 136, 19.99f);
		anOrder.addDigitalVideoDisc(dvd4);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Avatar", "Science Fiction", "James Cameron", 162, 29.50f);
		anOrder.addDigitalVideoDisc(dvd5);
		DigitalVideoDisc dvd6 = new DigitalVideoDisc("Titanic", "Romance", "James Cameron", 195, 15.99f);
		anOrder.addDigitalVideoDisc(dvd6);
		DigitalVideoDisc dvd7 = new DigitalVideoDisc("Inception", "Science Fiction", "Christopher Nolan", 148, 22.99f);
		anOrder.addDigitalVideoDisc(dvd7);
		DigitalVideoDisc dvd8 = new DigitalVideoDisc("Toy Story", "Animation", "John Lasseter", 81, 14.95f);
		anOrder.addDigitalVideoDisc(dvd8);
		DigitalVideoDisc dvd9 = new DigitalVideoDisc("Finding Nemo", "Animation", 16.99f);
		anOrder.addDigitalVideoDisc(dvd9);
		DigitalVideoDisc dvd10 = new DigitalVideoDisc("Jurassic Park", "Science Fiction", "Steven Spielberg", 127, 21.99f);
		anOrder.addDigitalVideoDisc(dvd10);
		DigitalVideoDisc dvd11 = new DigitalVideoDisc("The Godfather", "Crime", "Francis Ford Coppola", 175, 24.99f);
		anOrder.addDigitalVideoDisc(dvd11);
		DigitalVideoDisc dvd12 = new DigitalVideoDisc("Interstellar", "Science Fiction", "Christopher Nolan", 169, 25.50f);
		anOrder.addDigitalVideoDisc(dvd12);
		DigitalVideoDisc dvd13 = new DigitalVideoDisc("The Avengers", "Action", "Joss Whedon", 143, 19.95f);
		anOrder.addDigitalVideoDisc(dvd13);
		DigitalVideoDisc dvd14 = new DigitalVideoDisc("Spirited Away", "Animation", "Hayao Miyazaki", 125, 20.00f);
		anOrder.addDigitalVideoDisc(dvd14);
		DigitalVideoDisc dvd15 = new DigitalVideoDisc("Frozen", "Animation", 15.50f);
		anOrder.addDigitalVideoDisc(dvd15);
		DigitalVideoDisc dvd16 = new DigitalVideoDisc("Harry Potter", "Fantasy", "Chris Columbus", 152, 18.99f);
		anOrder.addDigitalVideoDisc(dvd16);
		DigitalVideoDisc dvd17 = new DigitalVideoDisc("Lord of the Rings", "Fantasy", "Peter Jackson", 178, 29.99f);
		anOrder.addDigitalVideoDisc(dvd17);
		DigitalVideoDisc dvd18 = new DigitalVideoDisc("Spider-Man", "Action", 22.99f);
		anOrder.addDigitalVideoDisc(dvd18);
		DigitalVideoDisc dvd19 = new DigitalVideoDisc("Shrek", "Animation", "Andrew Adamson", 90, 12.99f);
		anOrder.addDigitalVideoDisc(dvd19);
		DigitalVideoDisc dvd20 = new DigitalVideoDisc("The Dark Knight", "Action", "Christopher Nolan", 152, 23.99f);
		anOrder.addDigitalVideoDisc(dvd20);
		
		System.out.println("Total Cost is: ");
		System.out.printf("%.2f", anOrder.totalCost());
		System.out.println("");
		
		DigitalVideoDisc dvd21 = new DigitalVideoDisc("Hell's Paradise", "Action", 15.03f);
		anOrder.addDigitalVideoDisc(dvd21);
		System.out.println("Total Cost is: ");
		System.out.printf("%.2f", anOrder.totalCost());
		System.out.println("");
	}
}
