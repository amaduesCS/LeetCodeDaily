package ez.q69.mySqrt;

public class Solution {
    public int mySqrt(int x) {
        int result = x;
        int y = 2;
        while(result * result > x){
            result  =  result/y;
            y++;
        }
        return result;
    }
}
