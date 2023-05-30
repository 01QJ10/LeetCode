import java.util.* ;

class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        // if length is 0 return 0
        if(s.length() == 0) {
            return 0;
        }

        // check + - sign
        boolean isNegative = false;

        // check if subsequent characters are digits
        int start = 0;
        int end = 0;
        boolean foundDigits = false; // flag to track if any digits are found
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                end = i;
                if(!foundDigits) {
                    start = i; // update start index only when first digit is found
                    foundDigits = true;
                }
            }
            else if(c == '-' || c == '+') {
                if(i > 0) {
                    break; // if there are > 1 +- return 0
                }
                else if(c == '-') {
                    isNegative = true;
                }
            }
            else {
                break;
            }  
        }

        if(!foundDigits) {
            return 0; // return 0 if no digits are found
        }

        int result;
        try {
            result = Integer.parseInt(s.substring(start, end + 1));
        } catch(NumberFormatException e) {
            return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }

        if(isNegative) {
            result *= -1;
        }
        return result;
    }
}