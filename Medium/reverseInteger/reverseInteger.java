import java.util.*;

class Solution {
    public int reverseInteger(int x) {
        int last = 0;
        while (x != 0) {
            int remainder = x % 10;
            
            if (last > Integer.MAX_VALUE / 10 || (last == Integer.MAX_VALUE / 10 && remainder > 7))
                return 0;
            
            if (last < Integer.MIN_VALUE / 10 || (last == Integer.MIN_VALUE / 10 && remainder < -8))
                return 0;
            
            last = last * 10 + remainder;
            x /= 10;
        }
        return last;
    }
}