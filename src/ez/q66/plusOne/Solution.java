package ez.q66.plusOne;

import java.lang.reflect.Array;
import java.util.Arrays;

class Solution {
    public static int[] plusOne(int[] digits) {
        int[] digitsCopy = new int[digits.length+1];
        for (int i = digits.length-1; i >=0; i--) {
            if(digits[i] != 9){
                digits[i]++;
                digitsCopy[i+1] = digits[i];
                break;
            } else if (i==0){
                digits[i] =0;
                digitsCopy[0] = 1;
                digits = digitsCopy;
            } else {
                digits[i] =0;
            }
        }
        return digitsCopy;
    }

    public static void main(String[] args) {
        int[]  digits = {9,9,9};
        int[] ints = plusOne(digits);
        System.out.println(Arrays.toString(ints));

    }

}