import java.util.*;

class Solution {
    public int longestPalindrome(String s) {
        LinkedList<Character> ll_s = new LinkedList<Character>();
        int collisionCount = 0;
        for (int i=0; i<s.length(); i++) {
            Character t = Character.valueOf(s.charAt(i));
            if(ll_s.contains(t)) {
                ll_s.remove(t);
                collisionCount+=2;
            }
            else {
                ll_s.add(t);
            }
        }
        if(collisionCount < s.length()) {
            return collisionCount+1;
        }
        return collisionCount;
        
    }

    // public static void main(String args[]) {
    //     Solution sol = new Solution();
    //     System.out.println(sol.longestPalindrome("abccccdd"));
    // }
}