package medium.interview16.patternMatching;


/*TODO*/
class Solution {
    public static boolean patternMatching(String pattern, String value) {
        if(value.equals("")){
            return !(pattern.contains("a") && pattern.contains("b"));
        }
        int repeat = 0;
        char startChar = pattern.charAt(0);
        for (int i = 0; i < pattern.length(); i++) {
            if(pattern.charAt(i)!= startChar){
                break;
            }
            repeat ++;
        }

            return checkIfMatch("", 0, pattern, value, startChar, repeat);


    }

    static boolean checkIfMatch(String a, int index, String pattern, String value, Character start, int repeat){
        if(index > value.length()){
            return false;
        }


        String b = "";
        for (int i = index * repeat; i <= value.length(); i++) {
            String currentStr= "";
            for (int i1 = 0; i1 < pattern.length(); i1++) {
                if(pattern.charAt(i1) == start){
                    currentStr = currentStr + a;
                } else {
                    currentStr = currentStr + b;
                }
            }
            if(currentStr.equals(value) && !a.equals(b)){
                return true;
            }
            if(i< value.length()){
                String cutB = String.valueOf(value.charAt(i));
                b = b + cutB;
            }

        }
        String s = "";
        if(index < value.length()){
            s = String.valueOf(value.charAt(index));
        }
        String currA = a + s;
        index ++;
        return checkIfMatch(currA, index, pattern, value, start,repeat);

    }


    public static void main(String[] args) {
        System.out.println(patternMatching("bbbbbbbbabbbbbbbbbbbabbbbbbba", "zezezezezezezezezkxzezezezezezezezezezezezkxzezezezezezezezkx"));


    }
}