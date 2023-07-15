package ez.swordOffer017.printNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    //List<String> strList = new ArrayList<>();
    public int[] printNumbers(int n) {
        List<String> dfs = dfs(n);
        return dfs.stream().mapToInt(Integer::parseInt).toArray();
    }

    public List<String> dfs(int n){
        List<String> staticList = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            staticList.add(String.valueOf(i));
        }
        if(n==1){
            return staticList;
        }
        List<String> dfs = dfs(n - 1);
        List<String> temp = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            for (String df : dfs) {
                if(df.charAt(df.length()-1) == '1'){
                    temp.add(i+ df.substring(0, df.length()-1)+'0');
                }
                temp.add(i + df);

            }
        }
        staticList.addAll(temp);
        return staticList;

    }




    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.printNumbers(3)));

    }
}