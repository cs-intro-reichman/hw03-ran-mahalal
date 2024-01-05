	/** String processing exercise 2. */
public class UniqueChars {
    public static void main(String[] args) {  
        String str = args[0];
        System.out.println(uniqueChars(str));
    }

    /**
     * Returns a string which is identical to the original string, 
     * except that all the duplicate characters are removed,
     * unless they are space characters.
     */
    public static String uniqueChars(String s) {
    	String ans = "";
    	String used = "";
    	char current = '0';
        for (int i = 0; i < s.length(); i++) {
        	current = s.charAt(i);
        	if (current == 32) {
        		ans = ans + " ";
        	} else if (used.indexOf(current) == -1) {
        		ans = ans + current;
        		used = used + current;
        	} else {
        		used = used + current;
			}
        }
        return ans;
    }
}
