import java.util.* ;

class Solution {
    public void rotate(int[] nums, int k) {
        Stack<Integer> stack1 = new Stack <>();
        Stack<Integer> stack2 = new Stack <>();
        int i = nums.length - 1;
        k = k % nums.length;
        if(k == 0) {
            return;
        }
        while(i >= 0) {
            if(k > 0) {
                stack1.add(nums[i]);
                k--;
                i--;
            }
            else {
                stack2.add(nums[i]);
                i--;
            }
        }
        for(int j = 0; j < nums.length; j ++) {
            if(!stack1.empty()) {
                nums[j] = stack1.pop();
            }
            else {
                nums[j] = stack2.pop();
            }
        }
        return;
    }
}