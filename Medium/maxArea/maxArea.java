import java.util.*;

class Solution {
    public int maxArea(int[] height) {
        int start = 0;
        int end  = height.length - 1;
        int maxA = 0;
        while(start != end) {
            int area = Math.min(height[start], height[end]) * (end - start);
            if(area > maxA) {
                maxA = area;
            }
            if(height[start] > height[end]) {
                end -= 1;
            }
            else {
                start += 1;
            }
        }
        return maxA;        
    }
}