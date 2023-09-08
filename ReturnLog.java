
public class ReturnLog {
	private long ISBN;
	private long userID;
	private Date returnDate;
	private ReturnLog nextLog;
	
	public ReturnLog(long i, long user,Date d) {
		ISBN=i;
		userID=user;
		returnDate = d;
	}
	
	public long getISBN() {
		return ISBN;
	}
	public long getUserID() {
		return userID;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	
	public void setNextLog(ReturnLog a) {
		nextLog = a;
	}
	public ReturnLog getNextLog() {
		return nextLog;
	}
}
