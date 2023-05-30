import java.util.*;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) {
            return " ";
        }
        else if(strs.length == 1) {
            return strs[0];
        }
        else{
            int minLength = Integer.MAX_VALUE;
            for(String str: strs) {
                minLength = Math.min(str.length(), minLength);
            }

            int low = 0;
            int high = minLength;
            while(low <= high) {
                int mid = (low + high)/ 2;
                if(isCommonPrefix(strs, mid)) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
            return strs[0].substring(0, (low + high)/2);
        }
    }

    public boolean isCommonPrefix(String[] strs, int len) {
        String prefix = strs[0].substring(0, len);
        for(int i = 1; i < strs.length; i++) {
            if(!strs[i].startsWith(prefix)) {
                return false;
            }
        }
        return true;
    }
}