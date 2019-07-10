import java.util.*;

class Solution {


    private Stack<Character> pushToBigStack(String s) {
        Stack<Character> st = new Stack<Character>();
        st.push('\0');
        for (int i=0; i<s.length(); i++) {
            char c = Character.valueOf(s.charAt(i));
            st.push(c);
        }
        return st;
    }

    private char[] smallStackOperations(Stack<Character> st) {
        char arr[] = new char[1000];
        int arr_size = 0;
        char t;
        Stack<Character> temp = new Stack<Character>();
        while(!st.isEmpty()) {
            char c = st.pop();
            if(c != ' ' && c != '\0') {
                temp.push(c);
            }
            else {
                if(!temp.isEmpty()) {
                    while(!temp.isEmpty()) {
                        t = temp.pop();
                        arr[arr_size++] = t;
                    }
                    if(c == ' ')
                        arr[arr_size++] = c; //c is ' '
                }
            }
        }
        arr[arr_size] = '\0';
        return arr;
    }

    public String reverseWords(String s) {
        Stack<Character> st = pushToBigStack(s);
        char arr[] = smallStackOperations(st);
        String str_arr = new String(arr);
        return str_arr;
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        System.out.println(s.reverseWords("sky is blue"));
    }
}