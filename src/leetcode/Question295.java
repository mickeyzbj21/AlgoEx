package leetcode;


import java.util.PriorityQueue;

/**
 * 295. Find Median from Data Stream
 * The median is the middle value in an ordered integer list.If the size of the list is even,there is no middle value and the median is the mean of the two middle values.
 * For example,for arr=[2,3,4],the median is 3.
 * For example,for arr=[2,3],the median is(2+3)/2=2.5.
 * Implement the MedianFinder class:
 * MedianFinder()initializes the MedianFinder object.
 * void addNum(int num)adds the integer num from the data stream to the data structure.
 * double findMedian()returns the median of all elements so far.Answers within 10-5of the actual answer will be accepted.
 * <p>
 * Example 1:
 * Input
 * ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
 * [[],[1],[2],[],[3],[]]
 * Output
 * [null,null,null,1.5,null,2.0]
 * <p>
 * Explanation
 * MedianFinder medianFinder=new MedianFinder();
 * medianFinder.addNum(1);    // arr = [1]
 * medianFinder.addNum(2);    // arr = [1, 2]
 * medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
 * medianFinder.addNum(3);    // arr[1, 2, 3]
 * medianFinder.findMedian(); // return 2.0
 * <p>
 * <p>
 * Constraints:
 * -105<=num<=105
 * There will be at least one element in the data structure before calling findMedian.
 * At most 5*104calls will be made to addNum and findMedian.
 * <p>
 * <p>
 * Follow up:
 * If all integer numbers from the stream are in the range[0,100],how would you optimize your solution?
 * If 99%of all integer numbers from the stream are in the range[0,100],how would you optimize your solution?
 */
// TAG: DSChoice, PriorityQueue
public class Question295 {

    PriorityQueue<Integer> PQsmall;
    PriorityQueue<Integer> PQlarge;

    public Question295() {
        PQsmall = new PriorityQueue<>();
        PQlarge = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        // to balance the two PQs
        if (PQsmall.size() < PQlarge.size()) {
            PQlarge.add(num);
            PQsmall.add(PQlarge.poll());
        } else {
            PQsmall.add(num);
            PQlarge.add(PQsmall.poll());
        }
    }

    public double findMedian() {
        if (PQlarge.size() == PQsmall.size()) return (PQlarge.peek() + PQsmall.peek()) / 2.0;
        else return PQlarge.size() > PQsmall.size() ? PQlarge.peek() : PQsmall.peek();
    }


    public static void main(String[] args) {
        Question295 q = new Question295();
        q.addNum(-1);
        q.addNum(-2);
        System.out.println(q.findMedian());
        q.addNum(3);
        System.out.println(q.findMedian());
        q.addNum(-4);
        System.out.println(q.findMedian());
        q.addNum(-5);
        System.out.println(q.findMedian());
        System.out.println();
    }
}
