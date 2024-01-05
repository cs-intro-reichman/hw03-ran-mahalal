/** 
 * gets a given year, and prints the calendar of that year
 */
public class Calendar {	
    // Starting the calendar on 1/1/1900
	static int dayOfMonth = 1;   
	static int month = 1;
	static int year = 1900;
	static int dayOfWeek = 2;     // 1.1.1900 was a Monday
	static int nDaysInMonth = 31; // Number of days in January
	
	/** 
	 * Prints the calendar of a given year, also specifies if the day is Sunday.
	 */
	public static void main(String args[]) {
		int given_year = Integer.parseInt(args[0]);
		int debugDaysCounter = 0; 
	    
	 	while (year <= given_year) {
	 		if (year == given_year) {
	 			if (dayOfWeek == 1) {
					System.out.println(dayOfMonth + "/" + month + "/" + year + " Sunday");
				} else {
					System.out.println(dayOfMonth + "/" + month + "/" + year);
				}	 			
	 		}
	 			
	 		advance();
	 		debugDaysCounter++;
	 	
	 		if (false) { 
	 			break;
	 		}
        }
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
