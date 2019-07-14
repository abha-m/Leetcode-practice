import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null) {
            return 0;
        }
        // Approach 1
        // int i = 0;
        // List<Character> al = new ArrayList<Character>(); 
        // int max = 0;
        // while(i < s.length()) {
        //     char c = s.charAt(i);
        //     if(al.contains(c)) {
        //         int j = 0;
        //         while(j <= al.indexOf(c)) {
        //             al.remove(j);
        //         }   
        //     }
        //     al.add(c);
        //     max = (al.size() > max) ? al.size() : max;
        //     i++;
        // }

        // Approach 2
        Set<Character> hs = new HashSet<Character>();
        int i=0, j=0, max=0;
        while(i<s.length() && j<s.length()) {
            if(hs.add(s.charAt(j))) {
                max = (j-i+1)>max ? (j-i+1) : max;
                j++;
            }
            else {
                hs.remove(s.charAt(i));
                i++;
                max = (j-i+1)>max ? (j-i+1) : max;
            }
        }
        return max;
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLongestSubstring("abcabcbb"));
    }
}