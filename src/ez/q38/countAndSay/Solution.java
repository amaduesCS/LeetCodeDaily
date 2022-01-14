package ez.q38.countAndSay;

class Solution {
    public static String countAndSay(int n) {
        String[] results = new String[n];
        results[0] = "1";
        for (int i = 1; i < n; i++) {
            Character pre = null;
            int count = 1;
            results[i] = "";
            for (int i1 = 0; i1 < results[i-1].length(); i1++) {
                char c = results[i-1].charAt(i1);
                if(pre !=null && c==pre){
                    count++;
                }else if(pre!=null){
                    results[i] = results[i] + count + pre;
                    count = 1;
                }
                if(i1 == results[i-1].length()-1){
                    results[i] = results[i] + count + c;
                }
                pre = c;
            }
        }
        return results[n-1];
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(4));

    }
}