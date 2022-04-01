package crackingthecodinginterview.ch1;


/** 面试题 01.09. String Rotation
 Given two strings, s1and s2, write code to check if s2 is a rotation of s1 (e.g.,"waterbottle" is a rotation of"erbottlewat").Can you use only one call to the method that checks if one word is a substring of another?

 Example 1:
 Input: s1 = "waterbottle", s2 = "erbottlewat"
 Output: True

 Example 2:
 Input: s1 = "aa", s2 = "aba"
 Output: False
 */
public class Question1_9 {

    /**To Use double Loops (Use Mod so that the inner loop's maximum times is N)*/
    public boolean isFlipedString1(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        if (s1 == s2 || s1.equals(s2)) return true;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int N = c1.length;
        // System.out.println("N: "+N);
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int jj = j, ii = i;
                count = 0;
                while (jj < N && c2[jj] != c1[ii]) jj++;
                while (c2[jj++ % N] == c1[ii++ % N]) {
                    count++; // When meet the same char, count++
                    if (count == N) return true; // When have the same size of s1,bingo,is a rotational string
                }
            }
        }
        // System.out.println("count: "+count);
        return false;
    }

    /** Use String.contains Method*/
    public boolean isFlipedString2(String s1, String s2) {
        return s1.length() == s2.length() && (s2 + s2).contains(s1);
    }

    public static void main(String[] args) {
        String s1 = "waterbottle", s2 = "erbottlewat";
//        String s1 = "aab", s2 = "aba";
        Question1_9 q = new Question1_9();
        boolean b = q.isFlipedString2(s1, s2);
        System.out.println(b);
        String st1 = "";
        String st2 = "";
        System.out.println(st1 == st2); //true
    }

}
