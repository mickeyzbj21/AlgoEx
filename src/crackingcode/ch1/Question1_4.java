package crackingcode.ch1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 01.04. Palindrome Permutation LCCI
 * Given a string, write a function to check if it is a permutation of a palindrome. A palindrome is a word or phrase that is the same forwards and backwards. A permutation is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
 * Example1:
 * Input: "tactcoa"
 * Output: true（permutations: "tacocat"、"atcocta", etc.）
 **/

public class Question1_4 {


    // Use Sorting O(NlogN)
    public boolean canPermutePalindrome1(String s) {
        char[] a = s.toCharArray();
        int N = a.length;
        if(N==1) return true;
        Arrays.sort(a);
        if (N % 2 == 0) { // → Even 偶数
            for (int i = 0; i < N; i = i + 2) {
                if (a[i] != a[i + 1]) return false;
            }
        } else { //N%2!=0 → Odd 奇数
            int flag = 0;
            for (int i = 0; i < N - 1; i = i + 2) {

                if (a[i] != a[i + 1]) {
                    flag++;
                    i--;
                    if (flag == 2) return false;
                }
            }
            if (a[N - 1] != a[N - 2] && flag == 1) return false;
        }
        return true;
    }


    // TIP3:你试过散列表吗？你应该能把它降到O(N)的时间。
    // To use hash
    public boolean canPermutePalindrome2(String s) {
        char[] a = s.toCharArray();
        int N = a.length;
        if(N==0) return false;
        if(N==1) return true;
        HashMap<Character,Integer> h = new HashMap<>();
        for(char c : a) {
            h.put(c,h.getOrDefault(c,0)+1);
        }
        int flag = 0;
        for (int count : h.values()) {
            if(count%2!=0) flag++;
            if(flag==2) return false;
        }
        return true;
    }


    // TIP3:你试过散列表吗？你应该能把它降到O(N)的时间。
    // To use hash (use set instead of map)
    public boolean canPermutePalindrome3(String s) {
        char[] a = s.toCharArray();
        int N = a.length;
        if(N==0) return false;
        if(N==1) return true;
        HashSet<Character> h = new HashSet<>();
        for(char c : a) {
            if(h.contains(c)) h.remove(c);
            else h.add(c);
        }
        if(h.size()>1) return false;
        return true;
    }


    public static void main(String[] args) {

        Question1_4 q = new Question1_4();
        boolean b = q.canPermutePalindrome3("abbbb");
        System.out.println(b);

    }
}
