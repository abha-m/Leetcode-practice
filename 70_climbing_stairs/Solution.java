class Solution {

    public int climbStairs(int n) {
        if(n==0 || n==1 || n==2) {
            return n;
        }
        int stairs_arr[] = new int[n+1];
        for(int i=0; i<=2; i++) {
            stairs_arr[i] = i;
        }
        for(int i=3; i<=n; i++) {
            stairs_arr[i] = stairs_arr[i-1]+stairs_arr[i-2];
        }
        return stairs_arr[n];
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        System.out.println(s.climbStairs(4));
    }
}