package medium.q3.lengthOfLongestSubstring;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public static int lengthOfLongestSubstring(String s) {
        //int[] array = new int[26];
        Map<Character, Integer> map = new HashMap<>();
        if(s.length()==0){return 0;}
        int maxIndex = 0;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i)) != null){
                int max = Math.max(map.get(s.charAt(i)), maxIndex);

                maxIndex = map.get(s.charAt(i));
            }
            maxLength = Math.max(i - maxIndex, maxLength);
            map.put(s.charAt(i), i);
        }
        maxLength = Math.max(s.length() - maxIndex -1, maxLength);

        return maxLength;
    }

    public static void main(String[] args) {
        String s = "pwwabcdefghijk ^^";
        System.out.println(lengthOfLongestSubstring(s));


    }
}