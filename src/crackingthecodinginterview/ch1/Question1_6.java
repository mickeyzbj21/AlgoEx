package crackingthecodinginterview.ch1;

import java.util.HashMap;


/***面试题 01.06. Compress String
 Implement a method to perform basic string compression using the counts of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the "compressed" string would not become smaller than the original string, your method should return the original string. You can assume the string has only uppercase and lowercase letters (a - z).
 Example 1:
 Input: "aabcccccaaa"
 Output: "a2b1c5a3"
 Example 2:
 Input: "abbccd"
 Output: "abbccd"
 Explanation:
 The compressed string is "a1b2c2d1", which is longer than the original string.
 Note: 0 <= S.length <= 50000
 */
public class Question1_6 {

    // "aabcccccaa" → "a4b1c5" (But Need "a2b1c5a2")
    public String compressString1(String S) {
        char[] chars = S.toCharArray();
        HashMap<Character, Integer> h = new HashMap<>();
        for (char c : chars) {
            h.put(c, h.getOrDefault(c, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : h.keySet()) {
            sb.append(c);
            sb.append(h.get(c));
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    //"aabcccccaaa" → "a2b1c5a2"
    public String compressString2(String S) {
        /*To Deal With the Conner Case (Pre Processing)*/
        if (S == null) return null;
        char[] chars = S.toCharArray();
        // If Don't need compression
//        int j = 0;
//        for (j = 0; j < chars.length - 1; j++) {
//            if (chars[j] == chars[j + 1]) break;
//        }
//        if (j == chars.length - 1) return S;
        /*To Process*/
        StringBuilder sb = new StringBuilder();
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            char c = chars[i];
            int count = 1;
            sb.append(chars[i]);
            while (((i + 1) < length) && chars[i] == chars[i + 1]) {
                count++;
                i++;
            }
            sb.append(count);
        }
        //System.out.println(sb.toString());
        //If the "compressed" string would not become smaller than the original string, your method should return the original string
        return (sb.toString().length() >= S.length()) ? S : sb.toString();
    }

    public static void main(String[] args) {
        Question1_6 q = new Question1_6();
        q.compressString2("bbbac");
        q.compressString2("abcdefabdefjl");
        q.compressString2("abcdefabdefjll");
    }

}
