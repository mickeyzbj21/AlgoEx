package crackingcode.ch1;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 01.05. One Away LCCI
 * There are three types of edits that can be performed on strings: insert a character, remove a character, or replace a character. Given two strings, write a function to check if they are one edit (or zero edits) away.
 * <p>
 * Example 1:
 * Input:
 * first = "pale"
 * second = "ple"
 * Output: True
 * <p>
 * Example 2:
 * Input:
 * first = "pales"
 * second = "pal"
 * Output: False
 **/


public class Question1_5 {

    private static HashMap<Character, Integer> genHashMap(String s) {
        char[] array = s.toCharArray();
        HashMap<Character, Integer> h = new HashMap<>();
        for (char c : array) {
            h.put(c, h.getOrDefault(c, 0) + 1);
        }
        return h;
    }

    // Use hashMap; generate 2 maps then compare O(4N)
    // ab 与 bc 应该返回 false, 其中有一点理解错误，string本身的顺序是不能变的，
    // 不是通过一次edit，判断permutation(first)== permutation(second)
    // 而是通过一次edit，判断 first == second
    public boolean oneEditAway1(String first, String second) {
        int N1 = first.length();
        int N2 = second.length();
        if (N1 - N2 > 1 || N2 - N1 > 1) return false;
        HashMap<Character, Integer> h1 = genHashMap(first);
        HashMap<Character, Integer> h2 = genHashMap(second);
        if (h1.size() - h2.size() > 1 || h2.size() - h1.size() > 1) return false;
        if (h1.equals(h2)) return true;
        int flag = 0;
        for (char c : h1.keySet()) {
            if (!h2.containsKey(c)) {
                if (h1.get(c) > 1) return false;
                else flag++;
            } else {
                int n1 = h1.get(c);
                int n2 = h2.get(c);
                if (n1 == n2) continue;
                if (n1 - n2 > 1 || n2 - n1 > 1) return false;
                if (n1 - n2 == 1 || n2 - n1 == 1) flag++;
                if (flag > 1) return false;
            }
        }
        return true;
    }


    public boolean oneEditAway2(String first, String second) {
        int N1 = first.length();
        int N2 = second.length();
        if ((N1 == 0 && N2 == 1) || (N1 == 1 && N2 == 0)) return true;
        if (N1 - N2 > 1 || N2 - N1 > 1) return false;
        char[] c1Array = first.toCharArray();
        char[] c2Array = second.toCharArray();
        int flag = 0;
        if (N1 == N2) {
            for (int i = 0; i < N1; i++) {
                if (c1Array[i] != c2Array[i]) flag++;
                if (flag > 1) return false;
            }
        } else {
            if (N1 < N2) {
                for (int i = 0, j = 0; i < N1; i++, j++) {
                    if (c1Array[i] != c2Array[j]) {
                        flag++;
                        i--;
                    }
                    if (flag > 1) return false;
                }
            } else {
                for (int i = 0, j = 0; j < N2; i++, j++) {
                    if (c1Array[i] != c2Array[j]) {
                        flag++;
                        j--;
                    }
                    if (flag > 1) return false;
                }
            }
        }
        return true;
    }


    public boolean oneEditAway3(String first, String second) {
        char[] a = first.toCharArray();
        char[] b = second.toCharArray();
        int N1 = a.length;
        int N2 = b.length;
        if(N1==N2) {
            int c =  Arrays.mismatch(a, b);
            if(c==-1) return true;
            else{
                c = Arrays.mismatch(a,c+1,N1,b,c+1,N2);
                if(c==-1) return true;
                else return false;
            }
        }
        if(N1>N2) {
            int c = Arrays.mismatch(a, b);
            c = Arrays.mismatch(a,c+1,N1,b,c,N2);
            if(c==-1) return true;
            else return false;
        }
        else {
            int c = Arrays.mismatch(a, b);
            c = Arrays.mismatch(a,c,N1,b,c+1,N2);
            if(c==-1) return true;
            else return false;
        }

    }


    public static void main(String[] args) {
        Question1_5 q = new Question1_5();
        boolean b1 = q.oneEditAway3("horse", "ros");
        boolean b2 = q.oneEditAway3("pales", "palez");
        System.out.println(b1);
        System.out.println(b2);
    }
}
