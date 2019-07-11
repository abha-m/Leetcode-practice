import java.util.*;

class Solution {
    public String reverseVowels(String s) {
        if (s == null) {
            return null;
        }
        Stack<Character> vowelStack = new Stack<Character>();
        ArrayList<Integer> vowelIndex = new ArrayList<Integer>();
        char[] s_array = new char[s.length()];
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            s_array[i] = c;
            if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u' || c=='A' || c=='E' || c=='I' || c=='O' || c=='U') {
                vowelIndex.add(i);

                vowelStack.push(Character.valueOf(c));
            }
        }
        if(vowelStack.isEmpty()) {
            return s;
        }
        for(int i=0; i<vowelIndex.size(); i++) {
            char ch = vowelStack.pop();
            int index = vowelIndex.get(i);
            s_array[index] = ch;
        }
        System.out.println(s_array);
        String str = new String(s_array);
        return str;        
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        System.out.println(s.reverseVowels("leetcode"));
        
    }
}