
public enum SortCriteria {
	ISBN, NAME, AUTHOR, GENRE, YEAR, CONDITION;
	
	public String toString() {
		String a="";
		switch (this) {
		case ISBN:
			a = "ISBN";
			break;
		case NAME:
			a = "Name";
			break;
		case GENRE:
			a = "Genre";
			break;
		case YEAR:
			a = "Year";
			break;
		case CONDITION:
			a= "Condition";
			break;
		default:
			System.out.println("Not valid Condition");
			break;
		}
		return a;
	}
}
