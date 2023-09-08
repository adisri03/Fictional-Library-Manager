
public class Book {
	private String name;
	private String author;
	private String genre;
	private Condition bookCondition;
	private long ISBN;
	private int yearPublished;
	private long checkOutUserID;
	private Date checkOutDate;
	private Book nextBook;
	private boolean checkedOut;
	private int sortCond;

	public Book() {
		name = "The Giver";
		author = "Lois Lowry";
		genre = "fiction";
		bookCondition = Condition.NEW;
		ISBN = 666429998;
		yearPublished = 2005;
		nextBook = null;
		checkedOut = false;
	}

	public Book(long addISBN, String addName, String addAuthor, String addGenre, int year, Condition addCondition) {
		name = addName;
		author = addAuthor;
		genre = addGenre;
		bookCondition = addCondition;
		ISBN = addISBN;
		yearPublished = year;
		nextBook = null;
		checkedOut = false;
		if (addCondition == Condition.NEW) {
			sortCond = 1;
		} else if (addCondition == Condition.GOOD) {
			sortCond = 2;
		} else if (addCondition == Condition.BAD) {
			sortCond = 3;
		} else if (addCondition == Condition.REPLACE) {
			sortCond = 4;
		}
	}

	public String getName() {
		return name;
	}

	public String getAuthor() {
		return author;
	}

	public String getGenre() {
		return genre;
	}

	public Condition getCondition() {
		return bookCondition;
	}

	public long getISBN() {
		return ISBN;
	}

	public int getYear() {
		return yearPublished;
	}

	public int getSortC() {
		return sortCond;
	}

	public boolean isCheckedOut() {
		return checkedOut;
	}

	public long getCheckOutUserID() {
		return checkOutUserID;
	}

	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public Book getNextBook() {
		return nextBook;
	}

	public void setName(String n) {
		name = n;
	}

	public void setAuthor(String a) {
		author = a;
	}

	public void setGenre(String g) {
		genre = g;
	}

	public void setCondition(Condition c) {
		bookCondition = c;
	}

	public void setISBN(long i) {
		ISBN = i;
	}

	public void setYearPublished(int y) {
		yearPublished = y;
	}

	public void setCheckOutUserID(long id) {
		checkOutUserID = id;
	}

	public void setCheckOutDate(Date d) {
		checkOutDate = d;
	}

	public void setNextBook(Book b) {
		nextBook = b;
	}

	public void setCheckedOut(boolean n) {
		checkedOut = n;
	}

	public String toString() {
		return "\nName " + " |" + " Author " + " | " + " Genre " + " | " + " ISBN " + " | " + " Year Published " + "|"
				+ "Condition" + "|" + "\n=========================================================\n " + name + "|"
				+ author + "|" + genre + "|" + ISBN + "|" + yearPublished + "|" + (bookCondition) + "|" + "\n===="
				+ "=====================================================\n";
	}

	public void setYear(int year) {
		yearPublished = year;

	}

	public void setSortC(int sortC) {
		sortCond = sortC;

	}
}
