package medium.q2178.maximumEvenSplit;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<Long> maximumEvenSplit(long finalSum) {
        List<Long> longs= new ArrayList<>();
        if(finalSum%2 != 0){
            return longs;
        }
        for (long cut =2L; finalSum > 0; cut = cut +2){
            if(finalSum - cut >= 0){
                longs.add(cut);
            } else {
                Long aLong = longs.get(longs.size() - 1);
                longs.set(longs.size()-1, aLong + finalSum);
            }
            finalSum = finalSum -cut;
         }
        return  longs;
    }

    public static void main(String[] args) {
        long finalSum = 28;
        System.out.println(maximumEvenSplit(finalSum));
    }
}