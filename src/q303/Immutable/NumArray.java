package q303.Immutable;

class NumArray {

    int[] numSum;
    public NumArray(int[] nums) {
        this.numSum = new int[nums.length+1];
        numSum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            numSum[i+1] = numSum[i] + nums[i];
        }
    }
    
    public int sumRange(int i, int j) {
        return numSum[j+1] - numSum[i];
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(2,5));
    }
}