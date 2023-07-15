package ez.q35.searchInsert;

import java.util.Arrays;

class Solution {
    public static int searchInsert(int[] nums, int target) {
        int length = nums.length;
        if(length == 0){
            return 0;
        }
        int pivot = length/2; //if length ==1 pivot ==0,
        if(nums[pivot] < target){
            int[] newArray = Arrays.copyOfRange(nums, pivot + 1, nums.length);
            return pivot + searchInsert(newArray,target) + 1;
        }
        if(nums[pivot] > target){
            int[] newArray = Arrays.copyOfRange(nums,0,pivot);
            return searchInsert(newArray,target);
        }
        return pivot;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int i = searchInsert(nums, 5);
        System.out.println(i);
    }
}