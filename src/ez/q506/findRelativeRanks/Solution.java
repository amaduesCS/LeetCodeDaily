package ez.q506.findRelativeRanks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

class Solution {
    public static String[] findRelativeRanks(int[] score) {
        int[] ori = score.clone();
        HashMap<String,String> map = new HashMap<>();
        Arrays.sort(score);
        for (int i = 1; i <= score.length; i++) {
            if(i==1){
                map.put(String.valueOf(score[score.length-i]),"Gold Medal");
            }
            else if(i==2){
                map.put(String.valueOf(score[score.length-i]),"Silver Medal");
            }
            else if(i==3){
                map.put(String.valueOf(score[score.length-i]),"Bronze Medal");
            } else {
                map.put(String.valueOf(score[score.length-i]), String.valueOf(i));
            }
        }
        ArrayList<String> al = new ArrayList<>();
        for (int i = 0; i < ori.length; i++) {
            al.add(map.get(String.valueOf(ori[i])));
        }
        return al.toArray(new String[0]);
    }

    public static void main(String[] args) {
        int[] score = {10,3,8,9,4};
        System.out.println(Arrays.toString(findRelativeRanks(score)));
    }
}