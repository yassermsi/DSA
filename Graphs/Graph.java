import java.util.ArrayList;
import java.util.List;

import Queues.LinkedQueue;
import Stacks.ArrayStack;

public class Graph {
       private int n; // number of vertices
       private List<List<Integer>> adj;
       
       public Graph(int n) {
              this.n = n;
              adj = new ArrayList<>();
              for (int i = 0; i < n; i++)
                     adj.add(new ArrayList<>());
       }

       public void addEdge(int u, int v, boolean isDirected) {
              adj.get(u).add(v);
              if (!isDirected)
                     adj.get(v).add(u);
       }

       public List<Integer> getNeighbours(int u) {
              return adj.get(u);
       }

       public int size() {
              return n;
       }

       public void bfs(int start) {
              boolean[] visited = new boolean[n];
              LinkedQueue<Integer> q = new LinkedQueue<>();
              visited[start] = true;
              q.offer(start);
              while(!q.isEmpty()) {
                     int node = q.poll();
                     System.out.print(node + " ");
                     for (int nbr : adj.get(node)) 
                            if (!visited[nbr]) {
                                   visited[nbr] = true;
                                   q.offer(nbr);
                            }
              }
       }

       public void dfs(int start) {
              boolean visited[] = new boolean[n];
              ArrayStack<Integer> st = new ArrayStack<>();
              st.push(start);
              while(!st.isEmpty()) {
                     int node = st.pop();
                     if (!visited[node]) {
                            visited[node] = true;
                            System.out.print(node + " ");
                            for (int nbr : adj.get(node))
                                   if (!visited[nbr]) 
                                          st.push(nbr);
                     }
              }
       }
}