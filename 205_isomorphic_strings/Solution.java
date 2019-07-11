import java.util.*;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s=="") {
            return t=="";
        }
        if(t=="") {
            return s=="";
        }
        if(s==null) {
            return t==null;
        }
        if(t==null) {
            return s==null;
        }
        Set<Character> set_t = new HashSet<Character>();
        Map<Character, Character> m = new HashMap<Character, Character>();
        for(int i=0; i<s.length(); i++) {
            char c_s = s.charAt(i);
            char c_t = t.charAt(i);
            if(!m.containsKey(c_s)) {
                m.put(c_s, c_t);
                if(!set_t.add(c_t)) {
                    return false;
                }
            }
            else if(m.get(c_s) != c_t) {
                return false;
            }
        }
        return true;
    }        
        
    

    public static void main(String args[]) {
        Solution s = new Solution();
        System.out.print(s.isIsomorphic("", ""));
    }
}