package y2021.m02;

public class LongestOnes {
    public static int longestOnes(int[] A, int K) {
        int left = 0;
        int result = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i]==1){
            }else if (K > 0){
                K --;
            }else {
                while (A[left] != 0){
                    left ++;
                }
                left ++;
            }
            if (i - left +1 > result){
                result = i  - left +1;
            }
        }
        return result;
    }

    public static int longestOnes2(int[] A, int K) {
        int left = 0;
        int current = 0;
        int currentK = K;
        int result = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i]==0 && currentK > 0){
                currentK--;
            } else {
                while (A[left] != 0 ){
                    left ++;
                }
                left ++;
                currentK ++;
            }
            if (current - left > result){
                result = current - left;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {1,1,1,0,0,0,1,1,1,1,0};
        int i = longestOnes(A, 2);
        System.out.println(i);
    }
}
