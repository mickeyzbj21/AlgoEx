package crackingthecodinginterview.ch1;

import java.util.Arrays;
import java.util.HashMap;

public class Question1_2 {

    // 通过排序后进行比较O(NlogN)
    public boolean CheckPermutation1(String s1, String s2) {
        if(s1.length()!=s2.length()) return false;
        char[] s1CharArray = s1.toCharArray();
        char[] s2CharArray = s2.toCharArray();
        Arrays.sort(s1CharArray); // O(NlogN)
        Arrays.sort(s2CharArray); // O(NlogN)
        if(Arrays.compare(s1CharArray,s2CharArray)==0) return true; // O(N)
        else return false;
        // O(2NlogN+N) → O(NlogN)
    }

    // 通过将其放入Symbol Table中进行比较 O(N)
    // 有一种解法需要O(NlogN)的时间。另一种解法需要使用一些空间，但需要运行时间为O(N)
    public boolean CheckPermutation2(String s1, String s2) {
        if(s1.length()!=s2.length()) return false;
        HashMap<Character,Integer> h1 = generateHashMap(s1); // O(N)
        HashMap<Character,Integer> h2 = generateHashMap(s2); // O(N)
        if(h1.equals(h2)) return true; // O(N)
        return false;
        // O(N)
    }

    private static HashMap<Character,Integer> generateHashMap(String s){
        HashMap<Character,Integer> h = new HashMap<>();
        char[] sAttr = s.toCharArray();
//        for(int i = 0; i<sAttr.length;i++){
              // if not contain, put it there
//            if(!h.containsKey(sAttr[i])) h.put(sAttr[i],1);
              // if already there, get the value + 1, then put it back
//            else {
//                int count = h.get(sAttr[i]);
//                h.put(sAttr[i],++count);
//            }
//        }
        //用HashMap中的getOrDefault方法简化if-else操作
        for(char c: sAttr){
            h.put(c,h.getOrDefault(c,0)+1);
        }
        return h;
    }

    public static void main(String[] args) {
       String s1 = "abc", s2 = "bca";
       Question1_2 q = new Question1_2();
       System.out.println(q.CheckPermutation2(s1,s2));
    }
}
