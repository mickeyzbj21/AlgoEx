package leetcode;

/**824. Goat Latin*/
public class QL824 {

    public String toGoatLatin(String sentence) {
        String[] words = sentence.split("^(a|e|i|o|u).*");
        StringBuilder ma = new StringBuilder("maa");
        StringBuilder res = new StringBuilder();
        for(String w : words){
            if(w.matches("[aeiou]")) w = w+ma;
            else{
                w = w.substring(1)+w.substring(0,1)+ma;
            }
            ma.append("a");
            res.append(w+" ");
        }
        return  res.toString().substring(0,res.length()-1);
    }

    public static void main(String[] args) {
        System.out.println("over".matches("^(a|e|i|o|u).*"));
    }
}
