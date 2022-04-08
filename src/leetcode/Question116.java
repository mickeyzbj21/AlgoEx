package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**116.Populating Next Right Pointers in Each Node
        You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
        struct Node {
        int val;
        Node *left;
        Node *right;
        Node *next;
        }
        Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
        Initially, all next pointers are set to NULL.
        Example 1:
        Input: root = [1,2,3,4,5,6,7]
        Output: [1,#,2,3,#,4,5,6,7,#]
        Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
      */
//TAG: BFS,TreeTraverse
public class Question116 {

    // Definition for a Node.
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    // Method 1:BST
    public Node connect1(Node root) {
        if (root == null) return root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int sz = queue.size();
        while (!queue.isEmpty()) {
            for (int i = 0; i < sz; i++) {
                Node node = queue.poll();
                // TIP：don't use if(queue.peek()!=null) as a condition(the queue has changed)
                if (i != (sz - 1)) node.next = queue.peek();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            sz = queue.size();
        }
        return root;
    }

    // Method 2:Traverse (to Traverse the 3-arry Tree)
    // TIP：make the 2 be 3
    public Node connect2(Node root) {
        if(root==null) return root;
        traverse(root.left,root.right);
        return root;
    }
    private void traverse(Node left,Node right) {
        if(left==null||right==null) return;
        left.next = right;
        traverse(left.left,left.right);
        traverse(left.right,right.left);
        traverse(right.left,right.right);
    }

    // Method 3: Traverse (Recurse the middle part)
    // https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/solution/dong-hua-yan-shi-san-chong-shi-xian-116-tian-chong/
    public Node connect3(Node root) {
        if (root == null) return root;
        dfs(root);
        return root;
    }
    private void dfs(Node node) {
        if (node.left == null || node.right == null) return;
        Node left = node.left;
        Node right = node.right;
        while (left != null) {
            left.next = right;
            left = left.right;
            right = right.left;
        }
        dfs(node.left);
        dfs(node.right);
    }


    public static void main(String[] args) {
        Question116 q = new Question116();
        Node root = new Node(1);
        Node t1 = new Node(2);
        root.left = t1;
        Node t2 = new Node(3);
        root.right = t2;
        Node t3 = new Node(4);
        t1.left = t3;
        Node t4 = new Node(5);
        t1.right = t4;
        Node t5 = new Node(6);
        t2.left = t5;
        Node t6 = new Node(7);
        t2.right = t6;
        Node a = q.connect1(root);
        System.out.println(a);
    }

}
