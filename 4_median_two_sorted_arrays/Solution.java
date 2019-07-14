class Solution {

    private int findPartition2(int nums1_len, int nums2_len, int partition1) {
        return((nums1_len + nums2_len + 1) / 2) - partition1;
    }

    private double findMedian(int[] nums1, int[] nums2, int partition1, int partition2) {        
        int maxLeft1 = (partition1==0) ? Integer.MIN_VALUE : nums1[partition1-1];
        int maxLeft2 = (partition2==0) ? Integer.MIN_VALUE : nums2[partition2-1];
        int minRight1 = (partition1==nums1.length) ? Integer.MAX_VALUE :nums1[partition1];
        int minRight2 = (partition2==nums2.length) ? Integer.MAX_VALUE : nums2[partition2];
        if((maxLeft1 <= minRight2) && (maxLeft2 <= minRight1)) {
            if((nums1.length+nums2.length) % 2 == 0) {
                return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
            }
            else
                return Math.max(maxLeft1, maxLeft2);
        }
        else if(maxLeft1 > minRight2) {
            partition1--;
        }
        else {
            partition1++;
        }
        partition2 = findPartition2(nums1.length, nums2.length, partition1);
        System.out.println(partition2);
        return findMedian(nums1, nums2, partition1, partition2);
    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length <= nums2.length) {
            int partition1 = (nums1.length-1) / 2;
            int partition2 = findPartition2(nums1.length, nums2.length, partition1);
            return findMedian(nums1, nums2, partition1, partition2);
        }
        else {
            int partition1 = (nums2.length-1) / 2;
            int partition2 = findPartition2(nums1.length, nums2.length, partition1);
            return findMedian(nums2, nums1, partition1, partition2);
        }
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        System.out.println(s.findMedianSortedArrays(nums1, nums2));
    }
}