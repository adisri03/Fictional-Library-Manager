
public class Date {
	private int day;
	private int month;
	private int year;

	public Date() {
		day = 1;
		month = 1;
		year = 2023;
	}
	
	public Date(int d, int m, int y) {
		day = d;
		month = m;
		year = y;
	}

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	

	public static int compare(Date x, Date y) {//compares the two dates
		if ((x.getDay() == y.getDay()) && (x.getMonth() == y.getMonth()) && (x.getYear() == y.getYear())) {
			return 0;
		} else {
			if (x.getYear() < y.getYear()) {
				return -1;
			} else if (x.getYear() == y.getYear()) {
				if (x.getMonth() < y.getMonth()) {
					return -1;
				} else if (x.getMonth() == y.getMonth()) {
					if (x.getDay() < y.getDay()) {
						return -1;
					}
				}
			} else if (x.getYear() > y.getYear()) {
				return 1;
			} else if (x.getYear() == y.getYear()) {
				if (x.getMonth() > y.getMonth()) {
					return 1;
				} else if (x.getMonth() == y.getMonth()) {
					if (x.getDay() > y.getDay()) {
						return 1;
					}
				}
			}
		}

		return -1;

	}

	public boolean check(Date d) {//checks for valid or invalid date
		if(d.getMonth()>13) {
			return false;
		}
		else {
			if(d.getYear()%4==0&&(d.getYear()%100!=0||d.getYear()%400==0)){
				if(d.getMonth()==2) {
					if(d.getDay()>30) {
						return false;
					}
				}
			}
			else if(d.getYear()%4!=0) {
				if(d.getMonth()==2) {
					if(d.getDay()>29) {
						return false;
					}
				}
			}
			else if(d.getMonth()==1||d.getMonth()==3||d.getMonth()==5||d.getMonth()==7||d.getMonth()==8||d.getMonth()==10||d.getMonth()==12) {
				if(d.getDay()>32) {
					return false;
				}
			}else if(d.getMonth()==4||d.getMonth()==6||d.getMonth()==9||d.getMonth()==11) {
				if(d.getDay()>31) {
					return false;
				}
			} 
		}

		return true;
	}

	public String toString() {//prints date in correct format
		return day + "/" + month + "/" + year;
	}
}
