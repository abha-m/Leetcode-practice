class Solution {
    public int maxProfit(int[] prices) {

        if(prices.length == 0) {
            return 0;
        }

        int max_diff = 0;
        int min_elem = prices[0];
        int n = prices.length;
        int diff = 0;
        for(int i=0; i<n; i++) {
            if(prices[i] >= min_elem) {
                diff = prices[i] - min_elem;
                if(diff > max_diff) {
                    max_diff = diff;
                }
            }
            else {
                min_elem = prices[i];
            }
        }
        return max_diff;
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        int prices[] = {7,6,4,3,1};
        System.out.println(s.maxProfit(prices));
    }
}