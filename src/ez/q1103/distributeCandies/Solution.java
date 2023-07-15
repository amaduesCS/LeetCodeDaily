package ez.q1103.distributeCandies;

import java.util.Arrays;

class Solution {
    public static int[] distributeCandies(int candies, int num_people) {
        int loop = 0;
        int left = candies;
        int[] results = new int[num_people];
        while(left > (num_people * (num_people+1)/2   + loop * num_people * num_people)){
            left = left - (num_people * (num_people+1)/2   + loop * num_people * num_people);
            loop++;
        }
        for (int i = 0; i < num_people; i++) {
            if(left > (num_people  * loop + i+1 )){
                int value =(num_people  * loop + i+1 );
                left = left - value;
                results[i] = (i*2 + 2 + num_people  * loop) * (loop+1)/2;
            } else {
                if(loop ==0){
                    results[i] = left ;
                }else {
                    results[i] = left + (i*2 + 2 + num_people  * (loop-1))*loop/2 ;
                }
                left = 0;
            }
        }
        return results;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(distributeCandies(60, 4)));

    }
}