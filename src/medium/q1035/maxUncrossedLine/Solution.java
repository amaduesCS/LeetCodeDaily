package medium.q1035.maxUncrossedLine;

import java.util.Arrays;

class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int i, j = Integer.MAX_VALUE;
        if(nums1.length == 0 || nums2.length == 0){
            return 0;
        }
        boolean found = false;
        for (i = 0; i < nums1.length; i++) {
            for (j = 0; j < nums2.length; j++) {
                if(nums2[j] == nums1[i]){
                    found = true;
                    break;
                }
            }
            if(found){
                break;
            }

        }
        if(!found ){
            return 0;
        }
        int i1 = i+1 > nums1.length || j+1 > nums2.length ? 1: 1+ maxUncrossedLines(Arrays.copyOfRange(nums1, i+1, nums1.length), Arrays.copyOfRange(nums2, j+1, nums2.length));
        int i2 = i+1 > nums1.length? 0: maxUncrossedLines(Arrays.copyOfRange(nums1, i+1, nums1.length), nums2);
        return Math.max(i1, i2);
    }

    public static void main(String[] args) {
        Solution solution= new Solution();
        int[] nums1 = {3,1,4,1,1,3,5,1,2,2};
        int[] nums2 = {4,1,5,2,1,1,1,5,3,1,1,1,2,3,1,4,3,5,5,3,1,2,3,2,4,1,1,1,5,3};
        System.out.println(solution.maxUncrossedLines(nums1, nums2));

    }
}