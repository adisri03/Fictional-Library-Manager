
public class Shelf {
	private Book headBook;
	private Book tailBook;
	private Book cursorBook;
	private int length;
	private SortCriteria shelfSortCriteria;
	private String sortS;

	public Shelf() {
		headBook = null;
		tailBook = null;
		sortS = "ISBN";
	}

	public Book getHead() {
		return headBook;
	}

	public Book getTail() {
		return tailBook;
	}

	public void setHead(Book a) {
		headBook = a;
	}

	public void setTail(Book a) {
		tailBook = a;
	}

	public String getSortS() {
		return sortS;
	}

	public void addBook(Book bookadded) {
		if (headBook == null) {
			headBook = bookadded;
			tailBook = bookadded;
		} else {
			tailBook.setNextBook(bookadded);
			tailBook = bookadded;
		}
		
	}

	public void removeBook(long ISBN) throws BookDoesNotExistException {
		cursorBook = headBook;
		Book tempBook = null;
		boolean isRemoved = false;

		while (cursorBook != null) {
			if (headBook.getISBN() == ISBN) {
				isRemoved = true;
				headBook = cursorBook.getNextBook();
				break;
			}
			if (cursorBook.getNextBook().getISBN() == ISBN && cursorBook.getNextBook().getNextBook() != null) {
				isRemoved = true;
				cursorBook.setNextBook(cursorBook.getNextBook().getNextBook());
				break;
			}
			if (cursorBook.getNextBook().getNextBook() == null && cursorBook.getNextBook().getISBN() == ISBN) {
				isRemoved = true;
				tailBook = cursorBook;
				break;
			}
			cursorBook = cursorBook.getNextBook();
		}

		if (isRemoved == false) {
			throw new BookDoesNotExistException();
		}

	}

	public boolean isEmpty() {
		if (headBook == null) {
			return true;
		}
		return false;
	}

	public void sort(SortCriteria c) throws EmptyShelfException {

		if (c == SortCriteria.ISBN) {
			Book presentBook = headBook;
			Book indexBook;
			sortS = "ISBN";

			if (headBook == null) {
				throw new EmptyShelfException();
			} else {
				while (presentBook != null) {

					indexBook = presentBook.getNextBook();

					while (indexBook != null) {

						if (presentBook.getISBN() > indexBook.getISBN()) {
							String name = presentBook.getName();
							String author = presentBook.getAuthor();
							String genre = presentBook.getGenre();
							Condition bookCondition = presentBook.getCondition();
							long ISBN = presentBook.getISBN();
							int yearPublished = presentBook.getYear();
							long checkOutUserID = presentBook.getCheckOutUserID();
							Date checkOutDate = presentBook.getCheckOutDate();
							
							boolean checkedOut = presentBook.isCheckedOut();
							int sortCond = presentBook.getSortC();

							presentBook.setName(indexBook.getName());
							presentBook.setAuthor(indexBook.getAuthor());
							presentBook.setGenre(indexBook.getGenre());
							presentBook.setCondition(indexBook.getCondition());
							presentBook.setISBN(indexBook.getISBN());
							presentBook.setYear(indexBook.getYear());
							presentBook.setCheckOutUserID(indexBook.getCheckOutUserID());
							presentBook.setCheckOutDate(indexBook.getCheckOutDate());
							
							presentBook.setCheckedOut(indexBook.isCheckedOut());
							presentBook.setSortC(indexBook.getSortC());

							indexBook.setName(name);
							indexBook.setAuthor(author);
							indexBook.setGenre(genre);
							indexBook.setCondition(bookCondition);
							indexBook.setISBN(ISBN);
							indexBook.setYear(yearPublished);
							indexBook.setCheckOutUserID(checkOutUserID);
							indexBook.setCheckOutDate(checkOutDate);
						
							indexBook.setCheckedOut(checkedOut);
							indexBook.setSortC(sortCond);
						}

						indexBook = indexBook.getNextBook();
					}
					presentBook = presentBook.getNextBook();
				}
			}
		} else if (c == SortCriteria.NAME) {
			Book presentBook = headBook;
			Book indexBook;
			Book bookPtr;
			cursorBook = headBook;
			sortS = "Name";

			if (headBook == null) {
				throw new EmptyShelfException();
			} else {
				while (presentBook != null) {

					indexBook = presentBook.getNextBook();

					while (indexBook != null) {

						if (presentBook.getName().compareTo(indexBook.getName()) > 0) {
							String name = presentBook.getName();
							String author = presentBook.getAuthor();
							String genre = presentBook.getGenre();
							Condition bookCondition = presentBook.getCondition();
							long ISBN = presentBook.getISBN();
							int yearPublished = presentBook.getYear();
							long checkOutUserID = presentBook.getCheckOutUserID();
							Date checkOutDate = presentBook.getCheckOutDate();
					
							boolean checkedOut = presentBook.isCheckedOut();
							int sortCond = presentBook.getSortC();

							presentBook.setName(indexBook.getName());
							presentBook.setAuthor(indexBook.getAuthor());
							presentBook.setGenre(indexBook.getGenre());
							presentBook.setCondition(indexBook.getCondition());
							presentBook.setISBN(indexBook.getISBN());
							presentBook.setYear(indexBook.getYear());
							presentBook.setCheckOutUserID(indexBook.getCheckOutUserID());
							presentBook.setCheckOutDate(indexBook.getCheckOutDate());
						
							presentBook.setCheckedOut(indexBook.isCheckedOut());
							presentBook.setSortC(indexBook.getSortC());

							indexBook.setName(name);
							indexBook.setAuthor(author);
							indexBook.setGenre(genre);
							indexBook.setCondition(bookCondition);
							indexBook.setISBN(ISBN);
							indexBook.setYear(yearPublished);
							indexBook.setCheckOutUserID(checkOutUserID);
							indexBook.setCheckOutDate(checkOutDate);
						
							indexBook.setCheckedOut(checkedOut);
							indexBook.setSortC(sortCond);
						}

						indexBook = indexBook.getNextBook();
					}
					presentBook = presentBook.getNextBook();
				}
			}

		} else if (c == SortCriteria.AUTHOR) {
			Book presentBook = headBook;
			Book indexBook;
			Book bookPtr;
			cursorBook = headBook;
			sortS = "Author";

			if (headBook == null) {
				throw new EmptyShelfException();
			} else {
				while (presentBook != null) {

					indexBook = presentBook.getNextBook();

					while (indexBook!= null) {

						if (presentBook.getAuthor().compareTo(indexBook.getAuthor()) > 0) {
							String name = presentBook.getName();
							String author = presentBook.getAuthor();
							String genre = presentBook.getGenre();
							Condition bookCondition = presentBook.getCondition();
							long ISBN = presentBook.getISBN();
							int yearPublished = presentBook.getYear();
							long checkOutUserID = presentBook.getCheckOutUserID();
							Date checkOutDate = presentBook.getCheckOutDate();
					
							boolean checkedOut = presentBook.isCheckedOut();
							int sortCond = presentBook.getSortC();

							presentBook.setName(indexBook.getName());
							presentBook.setAuthor(indexBook.getAuthor());
							presentBook.setGenre(indexBook.getGenre());
							presentBook.setCondition(indexBook.getCondition());
							presentBook.setISBN(indexBook.getISBN());
							presentBook.setYear(indexBook.getYear());
							presentBook.setCheckOutUserID(indexBook.getCheckOutUserID());
							presentBook.setCheckOutDate(indexBook.getCheckOutDate());
				
							presentBook.setCheckedOut(indexBook.isCheckedOut());
							presentBook.setSortC(indexBook.getSortC());

							indexBook.setName(name);
							indexBook.setAuthor(author);
							indexBook.setGenre(genre);
							indexBook.setCondition(bookCondition);
							indexBook.setISBN(ISBN);
							indexBook.setYear(yearPublished);
							indexBook.setCheckOutUserID(checkOutUserID);
							indexBook.setCheckOutDate(checkOutDate);
						
							indexBook.setCheckedOut(checkedOut);
							indexBook.setSortC(sortCond);
						}

						indexBook = indexBook.getNextBook();
					}
					presentBook = presentBook.getNextBook();
				}
			}

		} else if (c == SortCriteria.GENRE) {
			Book presentBook = headBook;
			Book indexBook;
			Book bookPtr;
			cursorBook = headBook;
			sortS = "Genre";

			if (headBook == null) {
				throw new EmptyShelfException();
			} else {
				while (presentBook!= null) {

					indexBook = presentBook.getNextBook();

					while (indexBook != null) {

						if (presentBook.getGenre().compareTo(indexBook.getGenre()) > 0) {
							String name = presentBook.getName();
							String author = presentBook.getAuthor();
							String genre = presentBook.getGenre();
							Condition bookCondition = presentBook.getCondition();
							long ISBN = presentBook.getISBN();
							int yearPublished = presentBook.getYear();
							long checkOutUserID = presentBook.getCheckOutUserID();
							Date checkOutDate = presentBook.getCheckOutDate();
							
							boolean checkedOut = presentBook.isCheckedOut();
							int sortCond = presentBook.getSortC();

							presentBook.setName(indexBook.getName());
							presentBook.setAuthor(indexBook.getAuthor());
							presentBook.setGenre(indexBook.getGenre());
							presentBook.setCondition(indexBook.getCondition());
							presentBook.setISBN(indexBook.getISBN());
							presentBook.setYear(indexBook.getYear());
							presentBook.setCheckOutUserID(indexBook.getCheckOutUserID());
							presentBook.setCheckOutDate(indexBook.getCheckOutDate());
						
							presentBook.setCheckedOut(indexBook.isCheckedOut());
							presentBook.setSortC(indexBook.getSortC());

							indexBook.setName(name);
							indexBook.setAuthor(author);
							indexBook.setGenre(genre);
							indexBook.setCondition(bookCondition);
							indexBook.setISBN(ISBN);
							indexBook.setYear(yearPublished);
							indexBook.setCheckOutUserID(checkOutUserID);
							indexBook.setCheckOutDate(checkOutDate);
						
							indexBook.setCheckedOut(checkedOut);
							indexBook.setSortC(sortCond);
						}

						indexBook = indexBook.getNextBook();
					}
					presentBook = presentBook.getNextBook();
				}
			}

		} else if (c == SortCriteria.YEAR) {
			Book presentBook = headBook;
			Book indexBook;
			Book bookPtr;
			cursorBook = headBook;
			sortS = "Year";

			if (headBook == null) {
				throw new EmptyShelfException();
			} else {
				while (presentBook != null) {

					indexBook = presentBook.getNextBook();

					while (indexBook != null) {

						if (presentBook.getYear() > indexBook.getYear()) {
							String name = presentBook.getName();
							String author = presentBook.getAuthor();
							String genre = presentBook.getGenre();
							Condition bookCondition = presentBook.getCondition();
							long ISBN = presentBook.getISBN();
							int yearPublished = presentBook.getYear();
							long checkOutUserID = presentBook.getCheckOutUserID();
							Date checkOutDate = presentBook.getCheckOutDate();
							
							boolean checkedOut = presentBook.isCheckedOut();
							int sortCond = presentBook.getSortC();

							presentBook.setName(indexBook.getName());
							presentBook.setAuthor(indexBook.getAuthor());
							presentBook.setGenre(indexBook.getGenre());
							presentBook.setCondition(indexBook.getCondition());
							presentBook.setISBN(indexBook.getISBN());
							presentBook.setYear(indexBook.getYear());
							presentBook.setCheckOutUserID(indexBook.getCheckOutUserID());
							presentBook.setCheckOutDate(indexBook.getCheckOutDate());
					
							presentBook.setCheckedOut(indexBook.isCheckedOut());
							presentBook.setSortC(indexBook.getSortC());

							indexBook.setName(name);
							indexBook.setAuthor(author);
							indexBook.setGenre(genre);
							indexBook.setCondition(bookCondition);
							indexBook.setISBN(ISBN);
							indexBook.setYear(yearPublished);
							indexBook.setCheckOutUserID(checkOutUserID);
							indexBook.setCheckOutDate(checkOutDate);
				
							indexBook.setCheckedOut(checkedOut);
							indexBook.setSortC(sortCond);
						}

						indexBook = indexBook.getNextBook();
					}
					presentBook = presentBook.getNextBook();
				}
			}

		} else if (c == SortCriteria.CONDITION) {
			Book presentBook = headBook;
			Book indexBook;
			Book bookPtr;
			cursorBook = headBook;
			sortS = "Condition";

			if (headBook == null) {
				throw new EmptyShelfException();
			} else {
				while (presentBook != null) {

					indexBook = presentBook.getNextBook();

					while (indexBook != null) {

						if (presentBook.getSortC() > indexBook.getSortC()) {
							String name = presentBook.getName();
							String author = presentBook.getAuthor();
							String genre = presentBook.getGenre();
							Condition bookCondition = presentBook.getCondition();
							long ISBN = presentBook.getISBN();
							int yearPublished = presentBook.getYear();
							long checkOutUserID = presentBook.getCheckOutUserID();
							Date checkOutDate = presentBook.getCheckOutDate();
						
							boolean checkedOut = presentBook.isCheckedOut();
							int sortCond = presentBook.getSortC();

							presentBook.setName(indexBook.getName());
							presentBook.setAuthor(indexBook.getAuthor());
							presentBook.setGenre(indexBook.getGenre());
							presentBook.setCondition(indexBook.getCondition());
							presentBook.setISBN(indexBook.getISBN());
							presentBook.setYear(indexBook.getYear());
							presentBook.setCheckOutUserID(indexBook.getCheckOutUserID());
							presentBook.setCheckOutDate(indexBook.getCheckOutDate());
			
							presentBook.setCheckedOut(indexBook.isCheckedOut());
							presentBook.setSortC(indexBook.getSortC());

							indexBook.setName(name);
							indexBook.setAuthor(author);
							indexBook.setGenre(genre);
							indexBook.setCondition(bookCondition);
							indexBook.setISBN(ISBN);
							indexBook.setYear(yearPublished);
							indexBook.setCheckOutUserID(checkOutUserID);
							indexBook.setCheckOutDate(checkOutDate);
							
							indexBook.setCheckedOut(checkedOut);
							indexBook.setSortC(sortCond);
						}

						indexBook = indexBook.getNextBook();
					}
					presentBook = presentBook.getNextBook();
				}
			}
		}

	}

	public String toString() {
		
		return "";
	}

}
