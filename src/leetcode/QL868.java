package leetcode;

/**
 * 868. Binary Gap
 * Given a positive integer n,
 * find and return the longest distance between any two adjacent 1's
 * in the binary representation of n.
 * <p>
 * If there are no two adjacent 1's, return 0.
 * Two 1's are adjacent if there are only 0's separating them (possibly no 0's).
 * <p>
 * The distance between two 1's is the absolute difference between their bit positions.
 * For example, the two 1's in "1001" have a distance of 3.
 */
// TAG: Bit, Simulation
public class QL868 {

    public static int binaryGap(int n) {
        int last = -1;
        int res = 0;
        for (int i = 0; n != 0; i++) {
            // Important: Bit Manipulation: AND
            // n&1==1(the last digit=1)
            // n&1==0(the last digit=0)
            // #HOW to know the last digit is 1 OR 0
            if ((n & 1) == 1) {
                //JOT: WHY?last!=-1 (WHEN n=2^n E.g. 32→10 0000 i=5,last=0→res=5 just one 1
                // in the binary)
                if (last != -1) {
                    // #HOW to Find the longest distance
                    res = Math.max(res, i - last);
                }
                last = i;
            }
            // Important: Bit Manipulation: Right Shift
            // Right Shift 1 bit
            // JOT E.g. 32(10 0000)>>1=16,16(1 0000)>>1=8, 8(1000)>>1=4,
            //  4(100)>>1=2,2(10)>>1=1,1(1)>>1=0
            n >>= 1;
        }
        return res;
    }


    public static void main(String[] args) {

        System.out.println(QL868.binaryGap(32));

    }
}
