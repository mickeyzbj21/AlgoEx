package leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 819. Most Common Word
 * Given a string paragraph and a string array of the banned words banned, return the most frequent word that is not banned. It is guaranteed there is at least one word that is not banned, and that the answer is unique.
 * The words in paragraph are case-insensitive and the answer should be returned in lowercase.
 */
//TAG:Regex, Hash
public class QL819 {

    public String mostCommonWord(String paragraph, String[] banned) {
        HashMap<String, Integer> hp = new HashMap<>();
        String[] ss = paragraph.split("[^\\w]+");
        int max = 0;
        String maxS = "";
        HashSet<String> hs = new HashSet<>();
        for (String b : banned) {
            hs.add(b);
        }
        for (String s : ss) {
            s = s.toLowerCase();
//            if(s.contains("!")) s=s.replace("!","");
//            if(s.contains("?")) s=s.replace("?","");
//            if(s.contains("'")) s=s.replace("'","");
//            if(s.contains(",")) s=s.replace(",","");
//            if(s.contains(";")) s=s.replace(";","");
//            if(s.contains(".")) s=s.replace(".","");
            if (!hs.contains(s)) {
                hp.put(s, hp.getOrDefault(s, 0) + 1);
                if (hp.get(s) > max) {
                    max = hp.get(s);
                    maxS = s;
                }
            }
        }
        return maxS;
    }

    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        //String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        QL819 q = new QL819();
        String maxS = q.mostCommonWord(paragraph, banned);
        System.out.println(maxS);
    }
}
