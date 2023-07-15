package ez.q67.addBinary;

public class Solution {
    public static String addBinary(String a, String b) {
        int length = Math.max(a.length(), b.length());
        StringBuilder sb = new StringBuilder();
        int flag = 0;
        for (int i = 0; i < length; i++) {
            int bc = b.length() - 1 - i >= 0 ? Integer.parseInt(String.valueOf(b.charAt(b.length() - 1 - i))) : 0;
            int ac = a.length() - 1 - i >= 0 ? Integer.parseInt(String.valueOf(a.charAt(a.length() - 1 - i))) : 0;
            int judge = ac + bc + flag;
            if (judge == 3) {
                flag = 1;
                sb.append(1);
            } else if (judge == 2) {
                flag = 1;
                sb.append(0);
            } else if (judge == 1) {
                flag = 0;
                sb.append(1);
            } else {
                flag = 0;
                sb.append(0);
            }
        }
        if (flag == 1) {
            sb.append(1);
        }
        StringBuilder reverse = sb.reverse();
        return reverse.toString();
    }

    public static void main(String[] args) {
        String a = "11", b = "1";
        String s = addBinary(a, b);
        System.out.println(s);

    }

    // standard way:
    public String addBinary2(String a, String b) {
        StringBuffer ans = new StringBuffer();

        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; ++i) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append((char) (carry % 2 + '0'));
            carry /= 2;
        }

        if (carry > 0) {
            ans.append('1');
        }
        ans.reverse();

        return ans.toString();
    }


}
