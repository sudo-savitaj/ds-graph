//https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1/?company[]=Amazon&company[]=Amazon&problemType=functional&page=1&category[]=Graph&category[]=DFS&category[]=BFS&query=company[]AmazonproblemTypefunctionalpage1company[]Amazoncategory[]Graphcategory[]DFScategory[]BFS#
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
    void display() {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
//        5 4
//        0 1
//        0 2
//        0 3
//        2 4
        ArrayList<Integer> lsit0 = new ArrayList<>();
        lsit0.add(1);
        lsit0.add(2);
        lsit0.add(3);
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(0);
        ArrayList<Integer> lsit2 = new ArrayList<>();
        lsit2.add(0);
        lsit2.add(4);
        ArrayList<Integer> lsit3 = new ArrayList<>();
        lsit3.add(0);
        ArrayList<Integer> lsit4 = new ArrayList<>();
        lsit4.add(2);

        list.add(lsit0);
        list.add(list1);
        list.add(lsit2);
        list.add(lsit3);
        list.add(lsit4);

        ArrayList<Integer> res = bfsOfGraph(5,list);
        for(Integer item : res) System.out.println(item);
    }


    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        if (V <= 0) return null;

        boolean[] visited = new boolean[V];
        ArrayList<Integer> list = new ArrayList<>();

        Queue<Integer> queue = new LinkedList();
        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            Integer currentVertix = queue.remove();
            list.add(currentVertix);

            for (int i = 0; i < adj.get(currentVertix).size(); i++) {
                Integer nextVertix = adj.get(currentVertix).get(i);
                if (!visited[nextVertix]) {
                    visited[nextVertix] = true;
                    queue.add(nextVertix);
                }
            }

        }

        return list;
    }
}
