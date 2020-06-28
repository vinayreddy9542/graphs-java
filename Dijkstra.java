/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import java.util.Arrays;

/**
 *
 * @author reddy
 */
public class Dijkstra {
    private void dijkstraexec(int[][] graph,int src){
        int v = graph.length;
        int[] distance = new int[v];
        Arrays.fill(distance,Integer.MAX_VALUE);
        boolean[] used = new boolean[v];
        distance[src] = 0;
        for(int i=0;i<v-1;i++){
            int u = minimundistance(distance,used);
            used[u]=true;
            for(int j=0;j<v;j++){
                if(!used[j] && graph[u][j]!=0 && distance[u]!=Integer.MAX_VALUE && graph[u][j]<distance[j]){
                    distance[j] = distance[u]+graph[u][j];
                }
            }
        }
        //printing
        dijkstraprint(distance,src);
    }
    private void dijkstraprint(int[] distance,int src){
        System.out.println("Distance from "+src+" to :");
        for(int i=0;i<distance.length;i++){
            System.out.println(i+" "+distance[i]);
        }
    }
    private int minimundistance(int[] distance, boolean[] used) {
        int min = Integer.MAX_VALUE;
        int minindex = -1;
        int v = distance.length;
        for(int i=0;i<v;i++){
            if(used[i] == false && distance[i]<min){
                min = distance[i];
                minindex = i;
            }
        }
        return minindex;
    }
    
    public static void main(String[] sai){
        int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, 
                                      { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, 
                                      { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, 
                                      { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, 
                                      { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, 
                                      { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, 
                                      { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, 
                                      { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, 
                                      { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        Dijkstra dijkstra = new Dijkstra();
        dijkstra.dijkstraexec(graph,0);
    }
}
