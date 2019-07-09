import java.util.*;

class Solution {

    private int getElement(List<Integer> r, int index) {
        if(index >= r.size() || index < 0) {
            return 0;
        }
        return r.get(index);
    }


    public List<Integer> getRow(int rowIndex) {
        List <Integer> row = new ArrayList<Integer>();
        row.add(1);
        for (int i=0; i<= rowIndex; i++) {
            List<Integer> currRow = new ArrayList<Integer>();
            for (int j=0; j<i+1; j++) {
                int element = getElement(row, j-1) + getElement(row, j);
                currRow.add(j, element);
            }
            row = currRow;
        }
        return row;
    }


    // public static void main(String[] args) {
    //     Solution s = new Solution();
    //     System.out.println(s.getRow(0));
    // }
}