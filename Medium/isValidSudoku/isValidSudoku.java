import java.util.*;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> checked = new HashSet<>();

        for(int row = 0; row < 9; row ++) {
            for(int col = 0; col < 9; col ++) {
                char curr = board[row][col];
                if(curr == '.') {
                    continue;
                }
                String rowKey = curr + "in row " + row;
                if(!checked.add(rowKey)) {
                    return false;
                }

                String colKey = curr + "in col " + col;
                if(!checked.add(colKey)) {
                    return false;
                }

                String subgridKey = curr + "in subgrid " + (row/ 3) + "-" + (col/ 3);
                if(!checked.add(subgridKey)) {
                    return false;
                }
            }
        }
        return true;        
    }
}