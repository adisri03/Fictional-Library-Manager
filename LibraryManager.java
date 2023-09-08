import java.util.InputMismatchException;
import java.util.Scanner;

public class LibraryManager {

	public static void main(String[] args) throws InvalidUserIDException, InvalidISBNException {
		String a;
		String b;
		String c;
		int sh;
		BookRepository Library = new BookRepository();
		ReturnStack BookReturn = new ReturnStack(Library);

		Scanner s = new Scanner(System.in);
		do {
			System.out.println("Menu:\n" + "(B) – Manage Book Repository\n" + "         (C) – Checkout Book\n"
					+ "         (N) – Add New Book\n" + "         (R) – Remove Book\n"
					+ "         (P) – Print Repository\n" + "         (S) – Sort Shelf:\n"
					+ "             (I) – ISBN Number\n" + "             (N) – Name\n" + "	     (A) – Author\n"
					+ "	     (G) – Genre\n" + "             (Y) – Year\n" + "             (C) – Condition\n"
					+ "(R) – Manage Return Stack\n" + "    (R) – Return Book\n" + "    (S) – See Last Return\n"
					+ "    (C) – Check In Last Return\n" + "    (P) - Print Return Stack\n" + "(Q)-Quit");

			System.out.print("Please select what to manage: ");
			a = s.next();

			s.nextLine();

			if (a.toUpperCase().equals("B")) {
				System.out.print("Please select an option: ");
				b = s.next();
				if (b.toUpperCase().equals("C")) {

					try {
						int m;
						int d;
						int y;
						long ISBN;
						long UserID;
						System.out.println("Please Return day:");
						d = s.nextInt();
						System.out.println("Please Return month:");
						m = s.nextInt();
						System.out.println("Please Return year:");
						y = s.nextInt();
						System.out.println("Please ISBN of the book:");
						ISBN = s.nextLong();
						System.out.println("Please UserID:");
						UserID = s.nextLong();
						Date Redate = new Date(d, m, y);

						Library.checkOutBook(ISBN, UserID, Redate);

						System.out.println(Library.getBook(ISBN) + " has been checked out by " + Library.ID(UserID));

					} catch (InputMismatchException ex) {
						System.out.print("Please enter the correct information");
					} catch (InvalidISBNException e) {
						System.out.println("Invalid ISBN number");

					} catch (InvalidUserIDException e) {
						System.out.println("Invalid User ID number");

					} catch (BookAlreadyCheckedOutException e) {
						System.out.println("Book Already Checked Out");
					}

				} else if (b.toUpperCase().equals("N")) {
					
					try {
						long ISBN;
						String name;
						String genre;
						String author;
						int year;
						String l;
						Condition p = null;
						System.out.println("Please provide an ISBN number:");
						ISBN = s.nextLong();
						s.nextLine();
						System.out.println("Please provide a name:");
						name = s.nextLine();
						System.out.println("Please provide an author: ");
						author = s.next();
						System.out.println("Please provide an genre: ");
						genre = s.next();
						System.out.println("Please provide an year published:");
						year = s.nextInt();
						System.out.println("Please provide a condition(New, Good, Bad, Replace): ");
						String z = s.next();
						p=Condition.valueOf(z.toUpperCase());
						Library.addBook(ISBN, name, author, genre, year, p);
						System.out.println(name + " has been successfully added to the book repository!");
					} catch (InvalidISBNException e) {
						System.out.println("Invalid ISBN number");
					} catch (BookAlreadyExistsException q) {
						System.out.print("The book already exists");
					} catch (InputMismatchException n) {
						System.out.println("You have entered the wrong information. Please check!!");
					}catch(IllegalArgumentException h) {
						System.out.println("Invalid Condition!!");
					} catch (EmptyShelfException e) {
						System.out.println("Invalid Sort Critera");
					}
					
					

				} else if (b.toUpperCase().equals("R")) {
					long ISBN;
					System.out.print("Please provide an ISBN number:");
					ISBN = s.nextLong();
					try {

						try {
							Library.removeBook(ISBN);
						} catch (BookDoesNotExistException e) {
							System.out.println("Book Does Not Exist");
						}
						System.out.println(
								Library.getBook(ISBN) + " has been successfully removed from the book repository!");
					} catch (InvalidISBNException e) {
						System.out.println("Invalid ISBN number");
					} catch (EmptyShelfException e) {
						System.out.println("Shelf is empty");
					}

				} else if (b.toUpperCase().equals("P")) {
					System.out.println("Please the shelf you want to print:");
					int m = s.nextInt();
					try {
						Library.print(m);
					} catch (EmptyShelfException e) {
						System.out.println("Shelf is empty!!");
					}
				} else if (b.toUpperCase().equals("S")) {
					System.out.print("Please select a sorting criteria: ");
					c = s.next();
					if (c.toUpperCase().equals("C")) {
						System.out.print("Please the shelf you want to sort:");
						sh = s.nextInt();
						try {
							Library.sortShelf(sh, SortCriteria.CONDITION);
						} catch (InvalidSortCriteraException e) {
							System.out.println("Invalid Sort Critera");
						} catch (EmptyShelfException e) {
							System.out.println("Shelf is empty");
						}
					} else if (c.toUpperCase().equals("N")) {
						System.out.println("Please the shelf you want to sort:");
						sh= s.nextInt();
						try {
							Library.sortShelf(sh, SortCriteria.NAME);
						} catch (InvalidSortCriteraException e) {
							System.out.println("Invalid Sort Critera");
						} catch (EmptyShelfException e) {
							System.out.println("Shelf is empty");
						}

					} else if (c.toUpperCase().equals("I")) {
						System.out.println("Please the shelf you want to sort:");
						sh = s.nextInt();
						try {
							Library.sortShelf(sh, SortCriteria.ISBN);
						} catch (InvalidSortCriteraException e) {
							System.out.println("Invalid Sort Critera");
						} catch (EmptyShelfException e) {
							System.out.println("Shelf is empty");
						}

					} else if (c.toUpperCase().equals("A")) {
						System.out.println("Please the shelf you want to sort:");
						sh = s.nextInt();
						try {
							Library.sortShelf(sh, SortCriteria.AUTHOR);
						} catch (InvalidSortCriteraException e) {
							System.out.println("Invalid Sort Critera");
						} catch (EmptyShelfException e) {
							System.out.println("Shelf is empty");
						}

					} else if (c.toUpperCase().equals("Y")) {
						System.out.println("Please the shelf you want to sort:");
						sh= s.nextInt();
						try {
							Library.sortShelf(sh, SortCriteria.YEAR);
						} catch (InvalidSortCriteraException e) {
							System.out.println("Invalid Sort Critera");
						} catch (EmptyShelfException e) {
							System.out.println("Shelf is empty");
						}

					} else if (c.toUpperCase().equals("G")) {
						System.out.println("Please the shelf you want to sort:");
						sh = s.nextInt();
						try {
							Library.sortShelf(sh, SortCriteria.GENRE);
						} catch (InvalidSortCriteraException e) {
							System.out.println("Invalid Sort Critera");
						} catch (EmptyShelfException e) {
							System.out.println("Shelf is empty");
						}

					}
				}
			} else if (a.toUpperCase().equals("R")) {
				System.out.print("Please select an option: ");
				b = s.next();
				if (b.toUpperCase().equals("R")) {
					int m;
					int d;
					int y;
					long ISBN;
					long UserID;
					System.out.println("Please enter current day:");
					d = s.nextInt();
					System.out.println("Please enter current  month:");
					m = s.nextInt();
					System.out.println("Please enter current year:");
					y = s.nextInt();
					System.out.println("Please ISBN of the book:");
					ISBN = s.nextLong();
					System.out.println("Please UserID:");
					UserID = s.nextLong();
					Date Curdate = new Date(d, m, y);

					try {
						if (!BookReturn.pushLog(ISBN, UserID, Curdate)) {// checks if book is late
							while (!BookReturn.isEmpty()) {
								ReturnLog temp = BookReturn.popLog();
								Library.checkInBook(temp.getISBN());
							}
						}
						System.out.println(Library.getBook(ISBN) + " has been returned and needs to be cheked in");
					} catch (InvalidUserIDException e) {
						System.out.println("Invalid UserID number");
					} catch (InvalidISBNException e) {
						System.out.println("Invalid ISBN number");
					} catch (InvalidReturnDateException e) {
						System.out.println("Invalid Date");
					} catch (BookCheckedOutBySomeoneElseException e) {
						System.out.println("Book Checked Out By Someone Else");
					} catch (BookNotCheckedOutException e) {
						System.out.println("Book Not Checked Out");
					} catch (BookDoesNotExistException e) {
						System.out.println("Book Does Not Exist");
					}

					

				} else if (b.toUpperCase().equals("S")) {
					ReturnLog  sub = BookReturn.peek();
					System.out.println(Library.getBook(sub.getISBN())+" is the next book to be checked in");
				} else if (b.toUpperCase().equals("C")) {
					ReturnLog re = BookReturn.popLog();
					long ISBN = re.getISBN();
					long UserId = re.getUserID();
					Date ReDate = re.getReturnDate();

					Library.checkInBook(ISBN);

				} else if (b.toUpperCase().equals("P")) {
					ReturnStack TempReturn = new ReturnStack(Library);
					TempReturn = BookReturn;
					System.out.format("%-17s|%-20s|%-15s|\n", "ISBN ", " UserID ", " Return Date ");
					System.out.println("=========================================================================\n ");
					Book curbook;
					while (!TempReturn.isEmpty()) {
						TempReturn.print(TempReturn.popLog());

					}

				}
			}
		} while (!a.toUpperCase().equals("Q"));
		System.out.println("Sorry to see you go");

	}

}
