package hust.soict.globalict.aims;
import hust.soict.globalict.aims.media.*;
import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.store.Store;
import java.util.Scanner;

public class Aims {
	public static Store store = new Store();
	public static Cart cart = new Cart();
	public static Scanner sc = new Scanner(System.in);

	public static void testData() {
		store.addMedia(new DigitalVideoDisc("The Dark Knight", "Action", "Christopher Nolan", 152, 23.99));
		store.addMedia(new DigitalVideoDisc("Avatar", "Science Fiction", "James Cameron", 162, 29.50));
		store.addMedia(new DigitalVideoDisc("Jurassic Park", "Science Fiction", "Steven Spielberg", 127, 21.99));
		store.addMedia(new DigitalVideoDisc("Finding Nemo", "Animation", 16.99));
		store.addMedia(new Book(2, "How not to be wrong", "Math", 10.56));
		CompactDisc cd = new CompactDisc(1, "Frank Sinatra", "Music", "Various", "Frank Sinatra", 16.99);
		cd.addTrack(new Track("Fly Me to The Moon", 148));
		cd.addTrack(new Track("Jingle Bells", 121));
		store.addMedia(cd);
	}

	public static void main(String[] args) {
		testData();

		boolean exit = false;
		while (!exit) {
			showMenu();

			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
				case 1:
					viewStore();
					break;
				case 2:
					updateStore();
					break;
				case 3:
					seeCurrentCart();
					break;
				case 0:
					System.out.println("Thank you for using the service");
					exit = true;
					break;
				default:
					System.out.println("Invalid choice. Try again!");
			}
		}
		sc.close();
	}

	public static void viewStore() {
		boolean back = false;
		while (!back) {
			store.print();
			storeMenu();

			int choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
				case 1:
					seeMediaDetails();
					break;
				case 2:
					System.out.println("Enter media title to add to cart: ");
					String titleAdd = sc.nextLine();
					Media mediaAdd = store.searchByTitle(titleAdd);
					if (mediaAdd == null) {
						System.out.println("The media is not found");
					} else {
						cart.addMedia(mediaAdd);
						System.out.println("The media is added successfully");
						System.out.println("Current number of items in cart: " + cart.getSize());
					}
					break;
				case 3:
					playMedia(store);
					break;
				case 4:
					seeCurrentCart();
					break;
				case 0:
					back = true;
					break;
				default:
					System.out.println("Invalid choice. Try again!");
			}
		}
	}

	public static void seeMediaDetails() {
		System.out.println("Enter the media's title: ");
		String title = sc.nextLine();
		Media media = store.searchByTitle(title);

		if (media == null) {
			System.out.println("The media is not found");
		} else {
			System.out.println(media.toString());
			boolean back = false;
			while (!back) {
				mediaDetailsMenu();
				int choice = sc.nextInt();
				sc.nextLine();

				switch (choice) {
					case 1:
						cart.addMedia(media);
						System.out.println("The media is added to the cart");
						System.out.println("Current number of items in cart: " + cart.getSize());
						break;
					case 2:
						if (media instanceof Playable) {
							((Playable) media).play();
						} else {
							System.out.println("The media cannot be played");
						}
						break;
					case 0:
						back = true;
						break;
					default:
						System.out.println("Invalid choice. Try again!");
				}
			}
		}
	}

	public static void playMedia(Object container) {
		System.out.println("Enter the media's title to play: ");
		String title = sc.nextLine();
		Media m = null;

		if (container instanceof Store) {
			m = ((Store) container).searchByTitle(title);
		} else if (container instanceof Cart) {
			m = ((Cart) container).searchByTitle(title);
		}

		if (m == null) {
			System.out.println("The media is not found");
		} else {
			if (m instanceof Playable) {
				((Playable) m).play();
			} else {
				System.out.println("The media cannot be played");
			}
		}
	}

	public static void updateStore() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add a media");
		System.out.println("2. Remove a media");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");

		boolean back = false;
		while (!back) {
			int choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
				case 1:
					System.out.println("1.Add DVD\n2.Add CD\n3.Add Book");
					int type = sc.nextInt();
					sc.nextLine();
					System.out.println("Enter title: ");
					String titleAdd = sc.nextLine();
					System.out.println("Enter category: ");
					String categoryAdd = sc.nextLine();
					System.out.println("Enter cost: ");
					double costAdd = sc.nextDouble();
					sc.nextLine();

					Media newMedia = null;
					if (type == 1) {
						newMedia = new DigitalVideoDisc(titleAdd, categoryAdd, costAdd);
					} else if (type == 2) {
						newMedia = new CompactDisc(store.getSize() + 1, titleAdd, categoryAdd, "", "", costAdd);
					} else if (type == 3) {
						newMedia = new Book(store.getSize() + 1, titleAdd, categoryAdd, costAdd);
					}

					if (newMedia != null) {
						store.addMedia(newMedia);
					}
					break;
				case 2:
					System.out.println("Enter the media's title: ");
					String titleRemove = sc.nextLine();
					Media mediaRemove = store.searchByTitle(titleRemove);
					if (mediaRemove != null) {
						store.removeMedia(mediaRemove);
					} else {
						System.out.println("The media is not found");
					}
					break;
				case 0:
					back = true;
					break;
				default:
					System.out.println("Invalid choice. Try again!");
			}
		}
	}

	public static void seeCurrentCart() {
		boolean back = false;
		while (!back) {
			cart.print();
			cartMenu();

			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
				case 1:
					System.out.println("1.Filter by ID\n2.Filter by Title");
					int filterChoice = sc.nextInt();
					sc.nextLine();
					if (filterChoice == 1) {
						System.out.println("Enter ID: ");
						cart.searchByID(sc.nextInt());
						sc.nextLine();
					} else {
						System.out.println("Enter Title: ");
						Media m = cart.searchByTitle(sc.nextLine());
						if (m != null) {
							System.out.println(m.toString());
						} else {
							System.out.println("The media is not found");
						}
					}
					break;
				case 2:
					System.out.println("1.Sort by Title\n2.Sort by Cost");
					int sortChoice = sc.nextInt();
					sc.nextLine();
					if (sortChoice == 1) {
						cart.sortByTitle();
					} else {
						cart.sortByCost();
					}
					break;
				case 3:
					System.out.println("Enter the media's title to be removed: ");
					String titleRemove = sc.nextLine();
					Media m = cart.searchByTitle(titleRemove);
					if (m != null) {
						cart.removeMedia(m);
					} else {
						System.out.println("The media is not found");
					}
					break;
				case 4:
					playMedia(cart);
					break;
				case 5:
					System.out.println("Order created successfully!");
					cart = new Cart();
					break;
				case 0:
					back = true;
					break;
				default:
					System.out.println("Invalid choice. Try again!");
			}
		}
	}

	public static void showMenu() {
		System.out.println ("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store") ;
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}

	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media’s details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}

	public static void mediaDetailsMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		System.out.println("2. Play");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}

	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter media in cart");
		System.out.println("2. Sort media in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
	}
}