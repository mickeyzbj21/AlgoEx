package crackingthecodinginterview.ch1;

/**
 * 面试题 01.03. String to URL LCCI
 * Write a method to replace all spaces in a string with '%20'. You may assume that the string has sufficient space at the end to hold the additional characters,and that you are given the "true" length of the string. (Note: If implementing in Java,please use a character array so that you can perform this operation in place.)
 * Input: "Mr John Smith ", 13
 * Output: "Mr%20John%20Smith"
 **/

public class Question1_3 {

    public String replaceSpaces0(String S, int length) {
        return S.substring(0, length).replaceAll(" ", "%20");
    }


    public String replaceSpaces1(String S, int length) {
        S = S.substring(0, length);
        char[] sAttr = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : sAttr) {
            if (Character.isSpaceChar(c)) sb.append("%20");
            else sb.append(c);
        }
        return sb.toString();
    }

    //TIP1:从尾到头开始修改字符串通常最容易。
    public String replaceSpaces2(String S, int length) {
        S = S.substring(0, length);
        char[] sAttr = S.toCharArray();
        char[] rAttr = new char[length * 3];
        int j = length * 3 - 1;
        for (int i = length - 1; 0 <= i; i--) {
            if (Character.isSpaceChar(sAttr[i])) {
                rAttr[j] = '0';
                rAttr[--j] = '2';
                rAttr[--j] = '%';
            } else rAttr[j] = sAttr[i];
            --j;
        }
        String r = String.copyValueOf(rAttr, j + 1, rAttr.length - j - 1);
        return r;
    }

    // TIP2:你可能需要知道空格的数量。你能数一下吗？
    public String replaceSpaces3(String S, int length) {
        S = S.substring(0, length);
        char[] sAttr = S.toCharArray();
        int spaceCount = 0;
        for (char c : sAttr) if (Character.isSpaceChar(c)) spaceCount++;
        char[] rAttr = new char[length + spaceCount * 2];
        int j = length + spaceCount * 2 - 1;
        for (int i = length - 1; 0 <= i; i--) {
            if (Character.isSpaceChar(sAttr[i])) {
                rAttr[j--] = '0';
                rAttr[j--] = '2';
                rAttr[j--] = '%';
            } else rAttr[j--] = sAttr[i];
        }
        return String.copyValueOf(rAttr);
    }


    public static void main(String[] args) {
        String S = "Mr John Smith ";
        int length = 13;
        Question1_3 q = new Question1_3();
        System.out.println(q.replaceSpaces0(S, length));
    }
}
