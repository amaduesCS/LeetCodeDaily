package ez.q14.longestCommonPrefix;

public class Solution {

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};

        String s = longestCommonPrefix(strs);
        System.out.printf(s);
    }

    public static String longestCommonPrefixFor2(String str1, String str2){
        int length = Math.min(str1.length(), str2.length());
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if(str1.charAt(i) == str2.charAt(i)){
                stringBuilder.append(str1.charAt(i));
            } else {
                return stringBuilder.toString();
            }
        }
        return stringBuilder.toString();
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 1){
            return strs[0];
        }
        String s = strs[0];
        for (int i = 0; i < strs.length; i++) {
            s = longestCommonPrefixFor2(s, strs[i]);
        }
        return s;
    }
}
