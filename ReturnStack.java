import java.util.EmptyStackException;

public class ReturnStack {
	private ReturnLog topLog;
	private BookRepository LibTemp;

	public ReturnStack(BookRepository a) {
		topLog = null;
		LibTemp=a;
	}

	public boolean pushLog(long returnISBN, long returnUserID, Date returnDate)
			throws InvalidUserIDException, InvalidISBNException, InvalidReturnDateException, BookCheckedOutBySomeoneElseException, BookNotCheckedOutException, BookDoesNotExistException {
		
		if ((int) (Math.log10(returnISBN) + 1) > 13) {
			throw new InvalidISBNException();
		}
		if ((int) (Math.log10(returnUserID) + 1) >  10) {
			throw new InvalidUserIDException();
		}
		if (!returnDate.check(returnDate)) {
			throw new InvalidReturnDateException();
		}
		
		if((LibTemp.getBookObj(returnISBN).getCheckOutUserID()!=returnUserID)) {
			throw new BookCheckedOutBySomeoneElseException();
		}
		if(!LibTemp.getBookObj(returnISBN).isCheckedOut()) {
			throw new BookNotCheckedOutException();
		}
		
		ReturnLog newNode = new ReturnLog(returnISBN, returnUserID,returnDate);
		newNode.setNextLog(topLog);
		topLog = newNode;
		if(LibTemp.isLate(returnISBN, returnDate)==1) {
			return false;
		}
		
		return true;
	}

	public ReturnLog popLog() {
		ReturnLog answer;
		if (topLog == null) {// isEmpty
			throw new EmptyStackException();
		}

		answer = topLog;
		topLog = topLog.getNextLog();

		return answer;
	}

	public ReturnLog peek() {
		if(topLog==null) {
			throw new EmptyStackException();
		}
		return topLog;
	}

	public void print(ReturnLog a) {
		System.out.format("%-17s|%-20s|%-15s|\n",LibTemp.Isb(a.getISBN()) + " " + LibTemp.ID(a.getUserID()) + " " + a.getReturnDate().toString());
	}

	public boolean isEmpty() {
		if (topLog == null) {
			return true;
		}
		return false;
	}

}
