import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DFS {
    public void display() {
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

       ArrayList<Integer> res = dfsOfGraph(5,list);
       for(Integer item : res) System.out.println(item);
    }

    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        return dfsOfGraph(0, adj, visited);
    }

    private ArrayList<Integer> dfsOfGraph(int currentVertix, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {

        ArrayList<Integer> list = new ArrayList<>();
        visited[currentVertix] = true;
        list.add(currentVertix);


        for (int i = 0; i < adj.get(currentVertix).size(); i++) {
            Integer nextVertix = adj.get(currentVertix).get(i);
            if (!visited[nextVertix]) list.addAll(dfsOfGraph(nextVertix, adj, visited));
        }

        return list;
    }

}
