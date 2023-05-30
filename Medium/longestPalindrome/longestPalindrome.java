import java.util.*;

class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] table = new boolean[n][n];
        int maxLen = 0;
        int start = 0;

        // a letter by itself is also a palindrome
        for(int i = 0; i < n; i++) {
            table[i][i] = true;
            maxLen = 1;
        }

        // check for length 2 palindrome
        for(int i = 0; i < n - 1; i++) {
            if(s.charAt(i) == s.charAt(i + 1)) {
                table[i][i + 1] = true;
                start = i;
                maxLen = 2;
            }
        }

        // check for length >= 3 palindrome
        // k is the length of substring
        for(int k = 3; k <= n; k++) {
            for(int i = 0; i < n - k + 1; i++) {
                //initialise start pointer i and end pointer j
                int j = i + k - 1;
                if(s.charAt(i) == s.charAt(j) && table[i + 1][j - 1]) {
                    table[i][j] = true;
                    if(k > maxLen) {
                        start = i;
                        maxLen = k;
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}