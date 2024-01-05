
public class Calendar1 {	
    // Starting the calendar on 1/1/1900
	static int dayOfMonth = 1;   
	static int month = 1;
	static int year = 1900;
	static int dayOfWeek = 2;     // 1.1.1900 was a Monday
	static int nDaysInMonth = 31; // Number of days in January
	
	/** 
	 
	 */
	public static void main(String args[]) {
		int debugDaysCounter = 0; 
		int specialSunday = 0;
	    
	 	while (year < 2000) {
	 		if (dayOfWeek == 1) {
				System.out.println(dayOfMonth + "/" + month + "/" + year + " Sunday");
			} else {
					System.out.println(dayOfMonth + "/" + month + "/" + year);
			}

			if ((dayOfWeek == 1) && (dayOfMonth == 1)) {
				specialSunday++;
			}
	
	 		advance();
	 		debugDaysCounter++;
	 	
	 		if (false) { 
	 			break;
	 		}
        }

        System.out.println("During the 20th century, " + specialSunday + " Sundays fell on the first day of the month");
	}
	
	 // Advances the date (day, month, year) and the day-of-the-week.
	 // If the month changes, sets the number of days in this month.
	 // Side effects: changes the static variables dayOfMonth, month, year, dayOfWeek, nDaysInMonth.
	private static void advance() {
	 	nDaysInMonth = nDaysInMonth(month,year);
	 	if (dayOfWeek < 7) {
	 		dayOfWeek++;
	 	} else {
	 		dayOfWeek = 1;
	 	}

	 	if (nDaysInMonth == 28) {
	 		if (dayOfMonth < 28) {
	 			dayOfMonth++;
	 		} else { 
	 			dayOfMonth = 1;
	 			month++;
	 		}
	 	} else if (nDaysInMonth == 29) {
	 		if (dayOfMonth < 29) {
	 			dayOfMonth++;
	 		} else { 
	 			dayOfMonth = 1;
	 			month++;
	 		}
	 	} else if (nDaysInMonth == 30) {
	 		if (dayOfMonth < 30) {
	 			dayOfMonth++;
	 		} else { 
	 			dayOfMonth = 1;
	 			month++;
	 		}
	 	} else {
	 		if (dayOfMonth < 31) {
	 			dayOfMonth++;
	 		} else { 
	 			dayOfMonth = 1;
	 			month++;
	 		}
	 	}

	 	if (month == 13) {
	 		month = 1;
	 		year++;
	 	}
	}
	
		 
    // Returns true if the given year is a leap year, false otherwise.
	private static boolean isLeapYear(int year) {
	     boolean isLeapYear;
	    isLeapYear = ((year % 400) == 0) || (((year % 4) == 0) && ((year % 100) != 0));
		return isLeapYear;
	}
	 
	// Returns the number of days in the given month and year.
	// April, June, September, and November have 30 days each.
	// February has 28 days in a common year, and 29 days in a leap year.
	// All the other months have 31 days.
	private static int nDaysInMonth(int month, int year) {
		int numDays = 0;

		switch (month) {
			case 1: case 3: case 5: case 7: case 8: case 10: case 12:
				numDays = 31;
				break;
			case 4: case 6: case 9: case 11:
				numDays = 30;
				break;
			case 2:
				if(isLeapYear(year)) {
					numDays = 29;
				} else {
					numDays = 28;	
				}
				break;
				
		}
		return numDays;
	}
}
