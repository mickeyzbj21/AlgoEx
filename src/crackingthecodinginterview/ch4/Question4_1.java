package crackingthecodinginterview.ch4;

import java.util.*;

/**
 * 面试题 04.01. Route Between Nodes LCCI
 * Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
 * <p>
 * Example1:
 * <p>
 * Input: n = 3, graph = [[0, 1], [0, 2], [1, 2], [1, 2]], start = 0, target = 2
 * Output: true
 * Example2:
 * <p>
 * Input: n = 5, graph = [[0, 1], [0, 2], [0, 4], [0, 4], [0, 1], [1, 3], [1, 4], [1, 3], [2, 3], [3, 4]], start = 0, target = 4
 * Output true
 * Note:
 * <p>
 * 0 <= n <= 100000
 * All node numbers are within the range [0, n].
 * There might be self cycles and duplicated edges.
 */

public class Question4_1 {

    // Method1: to Use Adjacency List & DFS
    public boolean findWhetherExistsPath1(int n, int[][] graph, int start, int target) {
        ArrayList<Integer>[] AL = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            AL[i] = new ArrayList<>();
        }
        for (int i = 0; i < graph.length; i++) {
            int a = graph[i][0];
            int b = graph[i][1];
            if (!AL[a].contains(b)) AL[a].add(b);
        }
        boolean[] visit = new boolean[n];
        int[] edgeTo = new int[n];
        this.dfs1(AL, visit, edgeTo, start);
        //System.out.println(Arrays.toString(edgeTo));
        return visit[target];
    }

    private void dfs1(ArrayList<Integer>[] AL, boolean[] visit, int[] edgeTo, int start) {
        visit[start] = true;
        for (int i = 0; i < AL[start].size(); i++) {
            int e = AL[start].get(i);
            if (visit[e] == false) {
                edgeTo[e] = start;
                dfs1(AL, visit, edgeTo, e);
            }
        }
        return;
    }

    // Method2: to Use Adjacency List & DFS (When hitting the target, immediately return)
    private int target;
    private boolean result;

    public boolean findWhetherExistsPath2(int n, int[][] graph, int start, int target) {
        ArrayList<Integer>[] AL = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            AL[i] = new ArrayList<>();
        }
        for (int i = 0; i < graph.length; i++) {
            int a = graph[i][0];
            int b = graph[i][1];
            if (!AL[a].contains(b)) AL[a].add(b);
        }
        boolean[] visit = new boolean[n];
        int[] edgeTo = new int[n];
        this.target = target;
        this.dfs2(AL, visit, edgeTo, start);
        return this.result;
    }

    private void dfs2(ArrayList<Integer>[] AL, boolean[] visit, int[] edgeTo, int start) {
        visit[start] = true;
        for (int i = 0; i < AL[start].size(); i++) {
            int e = AL[start].get(i);
            if (e == this.target) {
                this.result = true;
                break;
            }
            if (visit[e] == false) {
                edgeTo[e] = start;
                dfs2(AL, visit, edgeTo, e);
            }
        }
        return;
    }

    // Method3: to Use Adjacency List & BFS
    public boolean findWhetherExistsPath3(int n, int[][] graph, int start, int target) {
        ArrayList<Integer>[] AL = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            AL[i] = new ArrayList<>();
        }
        for (int i = 0; i < graph.length; i++) {
            int a = graph[i][0];
            int b = graph[i][1];
            if (!AL[a].contains(b)) AL[a].add(b);
        }
        boolean[] visit = new boolean[n];
        int[] edgeTo = new int[n];
        Queue queue = new LinkedList();
        queue.add(start);
        this.bfs1(AL, visit, edgeTo, start, queue);
        //System.out.println(Arrays.toString(edgeTo));
        return visit[target];
    }

    private void bfs1(ArrayList<Integer>[] AL, boolean[] visit, int[] edgeTo, int start, Queue queue) {
        visit[start] = true;
        while (!queue.isEmpty()) {
            start = (int) queue.poll();
            for (int i = 0; i < AL[start].size(); i++) {
                int e = AL[start].get(i);
                if (visit[e] == false) {
                    edgeTo[e] = start;
                    visit[e] = true;
                    queue.add(e);
                }
            }
        }
    }

    // Method4: to Use Adjacency List & BFS (When hitting the target, immediately return)
    public boolean findWhetherExistsPath4(int n, int[][] graph, int start, int target) {
        ArrayList<Integer>[] AL = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            AL[i] = new ArrayList<>();
        }
        for (int i = 0; i < graph.length; i++) {
            int a = graph[i][0];
            int b = graph[i][1];
            if (!AL[a].contains(b)) AL[a].add(b);
        }
        boolean[] visit = new boolean[n];
        int[] edgeTo = new int[n];
        Queue queue = new LinkedList();
        queue.add(start);
        this.target = target;
        this.bfs2(AL, visit, edgeTo, start, queue);
        return this.result;
    }

    private void bfs2(ArrayList<Integer>[] AL, boolean[] visit, int[] edgeTo, int start, Queue queue) {
        visit[start] = true;
        while (!queue.isEmpty()) {
            start = (int) queue.poll();
            if (start == this.target) {
                this.result = true;
                break;
            }
            for (int i = 0; i < AL[start].size(); i++) {
                int e = AL[start].get(i);
                if (visit[e] == false) {
                    edgeTo[e] = start;
                    visit[e] = true;
                    queue.add(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        Question4_1 q = new Question4_1();
        int[][] graph = {{0, 1}, {0, 4}, {0, 12}, {1, 2}, {1, 3}, {1, 5}, {2, 10}, {3, 13}, {5, 6}, {5, 8}, {5, 9}, {5, 19}, {6, 7}, {8, 11}, {8, 14}, {10, 16}, {11, 15}, {12, 14}, {14, 17}, {14, 18}};
        boolean result = q.findWhetherExistsPath4(20, graph, 8, 11); //true
        System.out.println(result);
    }
}
