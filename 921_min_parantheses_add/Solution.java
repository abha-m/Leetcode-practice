import java.util.*;

class Solution {

    // Solution 1
    public int minAddToMakeValid1(String S) {
        if (S == null) {
            return 0;
        }
        char arrayOfClosedParantheses[] = new char[1000];
        int len_array = 0;
        Stack<Character> st = new Stack<Character>();
        for (int i=0; i<S.length(); i++) {
            char c = Character.valueOf(S.charAt(i));
            if(c == '(') {
                st.push(c);
            }
            else {
                if(!st.isEmpty()) {
                    st.pop();
                }
                else {
                    arrayOfClosedParantheses[len_array++] = c;
                }
            }
        }
        return st.size()+len_array;
    }

    // Solution 2
    public int minAddToMakeValid2(String S) {
        int count_open = 0;
        int count_closed = 0;
        if(S== null) 
            return 0;
        for (int i=0; i<S.length(); i++) {
            char c = S.charAt(i);
            if(c == '(') {
                count_open++;
            }
            else {
                if(count_open > 0) {
                    count_open--;
                }
                else {
                    count_closed++;
                }
            }
        }
        return count_open+count_closed;
    }
    

    public static void main(String args[]) {
        Solution s = new Solution();
        System.out.println(s.minAddToMakeValid1("()))(("));
        System.out.println(s.minAddToMakeValid2("()))(("));
    }


}