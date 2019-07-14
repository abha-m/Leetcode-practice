class Solution {

    public int maxSubArray(int[] nums) {
        int allMax = Integer.MIN_VALUE;
        int max = 0;
        for(int i=0; i<nums.length; i++) {
            max = Integer.max(max+nums[i], nums[i]);
            allMax = Integer.max(allMax, max);
        }
        return allMax;
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.print(s.maxSubArray(arr));
    }
}