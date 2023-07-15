package ez.q70.climbStairs;

class Solution {
    public int climbStairsDynamic(int n) {
        if(n== 0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return climbStairsDynamic(n-1) + (n-1)/2 + (n-1)%2;
    }
}