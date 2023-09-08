
public enum Condition {
	NEW, GOOD, BAD, REPLACE;
	
	public String toString() {
		String a="";
		switch (this) {
		case NEW:
			a = "New";
			break;
		case GOOD:
			a = "Good";
			break;
		case BAD:
			a = "Bad";
			break;
		case REPLACE:
			a = "Replace";
			break;
		default:
			System.out.println("Not valid Condition");
			break;
		}
		return a;
	}
	
	
}
