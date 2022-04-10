package leetcode;

import java.util.HashSet;

/**
 * 804. Unique Morse Code Words
 * International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows:
 * <p>
 * 'a' maps to ".-",
 * 'b' maps to "-...",
 * 'c' maps to "-.-.", and so on.
 * For convenience, the full table for the 26 letters of the English alphabet is given below:
 * <p>
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 * Given an array of strings words where each word can be written as a concatenation of the Morse code of each letter.
 * <p>
 * For example, "cab" can be written as "-.-..--...", which is the concatenation of "-.-.", ".-", and "-...". We will call such a concatenation the transformation of a word.
 * Return the number of different transformations among all words we have.
 */
// TAG:HashSet
public class Question804 {

    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        HashSet<String> hs = new HashSet<>();
        for (String s : words) {
            s = s.toLowerCase();
            char[] sChars = s.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (char c : sChars) {
                sb.append(morse[c - 'a']); // ~Time&Space: O(S(the length of all words))
            }
            hs.add(sb.toString());
        }
        return hs.size();
    }

    public static void main(String[] args) {
        Question804 q = new Question804();
        String[] s = {"a"};
        q.uniqueMorseRepresentations(s);
    }
}
