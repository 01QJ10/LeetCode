import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        Set<Character> unique = new HashSet<>();
        int n = s.length();
        int maxLen = 0;
        
        while(end < n) {
            Character curr = s.charAt(end);
            if(!unique.contains(curr)) {
                unique.add(curr);
                maxLen = Math.max(maxLen, end-start+1);
                end ++;
            }
            else {
                unique.remove(s.charAt(start));
                start ++;
            }
        }
        return maxLen;
    }
}