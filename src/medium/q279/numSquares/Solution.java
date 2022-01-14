package medium.q279.numSquares;

/*给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。

给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。

完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
*/


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class Solution {

    static Map<Integer,Integer>  result = new HashMap<>();

    public static int numSquares(int n) {
        int sqrt = (int)Math.sqrt(n);
        HashSet<Integer> set = new HashSet<>();
        for(int i = 1; i<= sqrt; i++){
            set.add( (int) Math.pow(i,2));
        }
        result.put(0,0);
        result.put(1,1);
        for(int i = 2; i<= n; i++){
            int min = Integer.MAX_VALUE;
            for (Integer integer : set) {
                if(integer<=i){
                    int temp =  result.get(i-integer)+1;
                    min = Math.min(min,temp);
                }

            }
            result.put(i,min);
        }
        return result.get(n);
    }

    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }
}