import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null) {
            return 0;
        }
        int i = 0;
        List<Character> al = new ArrayList<Character>(); 
        int max = 0;
        while(i < s.length()) {
            char c = s.charAt(i);
            if(al.contains(c)) {
                int j = 0;
                while(j <= al.indexOf(c)) {
                    al.remove(j);
                }   
            }
            al.add(c);
            max = (al.size() > max) ? al.size() : max;
            i++;
        }
        return max;
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLongestSubstring(""));
    }
}