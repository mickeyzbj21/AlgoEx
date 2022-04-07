package crackingcode.ch1;

public class Question1_1 {

    public boolean isUnique(String astr) {
        char[] strc = astr.toCharArray();
        for(int i = 0; i < strc.length-1;i++ ){
            for(int j = i+1; j < strc.length;j++){
                if(strc[i]==strc[j]) return false;
            }
        }
        return  true;
    }

    // Complexity Time: The best O(1), The worst O(1/2 n^2)
    // Complexity Space: 2n bytes (char = 16bits)
    public boolean isUnique2(String astr) {
        return astr.chars().distinct().count() == astr.length();
    }


    public static void main(String[] args) {
        String s1 = "static";
        String s2 = "abc";
        String s3 = "sabcdefs";
        String s4 = "abcdefgg";
        Question1_1 q = new Question1_1();
        System.out.println(q.isUnique2(s1));
        System.out.println(q.isUnique2(s2));
        System.out.println(q.isUnique2(s3));
        System.out.println(q.isUnique2(s4));
        s3.chars().distinct().forEach(s-> System.out.print((char)s));
    }


}
