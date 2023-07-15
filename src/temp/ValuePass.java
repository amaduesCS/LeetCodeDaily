package temp;

import java.util.Arrays;

public class ValuePass {

    static void  changeValue(Integer[] ints){
        //ints = new Integer[]{2,3,4};
        for (int i = 0; i < ints.length; i++) {
            ints[i] = 0;
        }
    }


    public static void main(String[] args) {
        Integer[] abc = {1,2,3};
        changeValue(abc);
        System.out.println(Arrays.toString(abc));
    }


}
