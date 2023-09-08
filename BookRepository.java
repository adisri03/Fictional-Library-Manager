
public class BookRepository {
	private Shelf shelves[];
	private Book curBook;

	public BookRepository() {
		shelves = new Shelf[10];
		curBook = null;
		for (int i = 0; i < shelves.length; i++) {
			shelves[i] = new Shelf();
		}
	}

	public String Isb(long ISBN) {
		String num = String.valueOf(ISBN);
		String l = "";
		if (num.length() < 13) {
			int d = 13 - num.length();
			for (int i = 0; i < d; i++) {
				l += "0";
			}
			l += num;
		} else {
			l = num;
		}
		return l;
	}

	public String ID(long Id) {
		String num = String.valueOf(Id);
		String l = "";
		if (num.length() < 10) {
			int d = 10 - num.length();
			for (int i = 0; i < d; i++) {
				l += "0";
			}
			l += num;
		} else {
			l = num;
		}
		return l;
	}

	public void addBook(long addISBN, String addName, String addAuthor, String addGenre, int year,
			Condition addCondition) throws InvalidISBNException, BookAlreadyExistsException, EmptyShelfException {
		String num = String.valueOf(addISBN);

		if ((int) Math.floor((Math.log10(addISBN) + 1)) > 13) {
			throw new InvalidISBNException();
		}

		Book addBook = new Book(addISBN, addName, addAuthor, addGenre, year, addCondition);

		for (int i = 0; i < shelves.length; i++) {
			if (!shelves[i].isEmpty()) {
				curBook = shelves[i].getHead();
				while (curBook != null) {
					if (curBook.getISBN() == addISBN) {
						throw new BookAlreadyExistsException();
					}
					curBook = curBook.getNextBook();

				}
			}
		}
		long d = (long) Math.pow(10, 12);
		int shelve = (int) (addISBN / d);// adding to specific shelf
		if (num.length() < 13) {
			d = 0;
		}

		shelves[shelve].addBook(addBook);
		shelves[shelve].sort(SortCriteria.valueOf(shelves[shelve].getSortS().toUpperCase()));

	}

	public void checkInBook(long checkedInISBN) throws InvalidUserIDException, InvalidISBNException {
		if ((int) (Math.log10(checkedInISBN) + 1) > 13) {
			throw new InvalidISBNException();
		}
		for (int i = 0; i < shelves.length; i++) {
			curBook = shelves[i].getHead();
			Book tempHead = shelves[i].getHead();
			while (curBook != null) {
				if (curBook.getISBN() == checkedInISBN) {
					curBook.setCheckedOut(false);
					break;
				}

				curBook = curBook.getNextBook();
			}
		}

	}

	public int isLate(long ISBN, Date c) throws BookDoesNotExistException {// checks if book is or not
		Date a = null;
		for (int i = 0; i < shelves.length; i++) {
			curBook = shelves[i].getHead();
			Book tempHead = shelves[i].getHead();
			while (curBook != null) {
				if (tempHead.getISBN() == ISBN) {
					a = tempHead.getCheckOutDate();
				}

				curBook = curBook.getNextBook();
			}

		}
		if(a==null) {
			throw new BookDoesNotExistException();
		}
		return Date.compare(c, a);// compares two dates
	}

	public void removeBook(long removeISBN)
			throws InvalidISBNException, EmptyShelfException, BookDoesNotExistException {
		Book temp = null;
		if ((int) (Math.log10(removeISBN) + 1) > 13) {
			throw new InvalidISBNException();
		}
		long d = (long) Math.pow(10, 12);
		int shelve = (int) (removeISBN / d);

		shelves[shelve].removeBook(removeISBN);

	}

	public String getBook(long ISBN) {// gets book name from ISBN
		Book curBook;
		String a = "";
		for (int i = 0; i < shelves.length; i++) {
			curBook = shelves[i].getHead();
			while (curBook != null) {
				if (curBook.getISBN() == ISBN) {
					a = curBook.getName();
				}
				curBook = curBook.getNextBook();
			}
		}
		return a;
	}

	public Book getBookObj(long ISBN) {// gets book object from ISBN
		Book curBook;
		Book temp = null;
		String a = "";
		for (int i = 0; i < shelves.length; i++) {
			curBook = shelves[i].getHead();
			while (curBook != null) {
				if (curBook.getISBN() == ISBN) {
					temp = curBook;
				}
				curBook = curBook.getNextBook();
			}
		}
		return temp;
	}

	public void checkOutBook(long checkedOutISBN, long checkOutUserID, Date checkOutDate)
			throws InvalidISBNException, InvalidUserIDException, BookAlreadyCheckedOutException {
		boolean isChecked = false;
		if ((int) (Math.log10(checkedOutISBN) + 1) > 13) {// checks for ISBN
			throw new InvalidISBNException();
		}
		if ((int) (Math.log10(checkOutUserID) + 1) > 10) {// checks for User ID
			throw new InvalidUserIDException();
		}
		for (int i = 0; i < shelves.length; i++) {
			curBook = shelves[i].getHead();
			Book tempHead = shelves[i].getHead();
			while (curBook != null) {
				if (tempHead.getISBN() == checkedOutISBN) {
					if (tempHead.isCheckedOut()) {
						throw new BookAlreadyCheckedOutException();
					}
					tempHead.setCheckedOut(true);
					tempHead.setCheckOutUserID(checkOutUserID);
					tempHead.setCheckOutDate(checkOutDate);
					break;
				} else if (curBook.getISBN() == checkedOutISBN) {
					if (curBook.isCheckedOut()) {
						throw new BookAlreadyCheckedOutException();
					}
					curBook.setCheckedOut(true);
					curBook.setCheckOutUserID(checkOutUserID);
					curBook.setCheckOutDate(checkOutDate);
					break;
				}
				curBook = curBook.getNextBook();
			}
		}

	}

	public void sortShelf(int shelfInd, SortCriteria c) throws InvalidSortCriteraException, EmptyShelfException {
		
		boolean p = false;
		for (SortCriteria t : SortCriteria.values())
			if (t.equals(c)) {
				p = false;
				break;// checks for Sort criteria
			} else {
				p = true;
			}
		if (p) {
			throw new InvalidSortCriteraException();
		}
		
		shelves[shelfInd].sort(c);
	}

	public void isValidCondition(Condition c) throws InvalidConditionCriteraException {

		for (Condition t : Condition.values())
			if (!t.equals(c)) {
				throw new InvalidConditionCriteraException();// checks for valid condition
			}
	}

	public void print(int shelf) throws EmptyShelfException {// prints shelf

		System.out.format("%-17s|%-20s|%-15s|%-12s|\n", shelves[shelf].getSortS(), " Checkout ", " Due Date ",
				" Checkout UserID ");
		System.out.println("=========================================================================\n ");
		Book curbook;
		String fCol = "";

		if (!shelves[shelf].isEmpty()) {
			curbook = shelves[shelf].getHead();
			String check = "";
			while (curbook != null) {
				if (shelves[shelf].getSortS().equals("ISBN")) {
					fCol = Isb(curbook.getISBN());
				} else if (shelves[shelf].getSortS().equals("Name")) {
					fCol = curbook.getName();
				} else if (shelves[shelf].getSortS().equals("Author")) {
					fCol = curbook.getAuthor();
				} else if (shelves[shelf].getSortS().equals("Genre")) {
					fCol = curbook.getGenre();
				} else if (shelves[shelf].getSortS().equals("Year")) {
					fCol = String.valueOf(curbook.getYear());
				} else if (shelves[shelf].getSortS().equals("Condition")) {
					fCol = (curbook.getCondition()).toString();
				}
				if (curbook.isCheckedOut()) {
					check = "Checked out";

					System.out.format("%-17s|%-20s|%-15s|%-17s|\n", fCol, check, curbook.getCheckOutDate().toString(),
							ID(curbook.getCheckOutUserID()));
					System.out.print("------------------------------------------------------------------------\n");
				} else {
					check = "Not Checked out";

					System.out.format("%-17s|%-20s|%-15s|%-17s|\n", fCol, check, "N/A", "N/A");
					System.out.print("-------------------------------------------------------------------------\n");
				}

				curbook = curbook.getNextBook();

			}
		} else {
			throw new EmptyShelfException();
		}

	}

}
