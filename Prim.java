/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author reddy
 */
public class Prim {
    
    private void primexec(int[][] graph) {
        int v = graph.length;
        int[] parent = new int[v];
        int[] key = new int[v];
        Arrays.fill(key, Integer.MAX_VALUE);
        boolean[] visited = new boolean[v];
        
        //base condition include base vertex as key
        key[0] = 0;
        //make the first node as root of the graph
        parent[0] = -1;
        //v-1 beacause first node is by default added to mst
        for(int i=0;i<v-1;i++){
            int num = minimumKey(key,visited);
            visited[num] = true;
            for(int j=0;j<v;j++){
                if(graph[num][j]!=0 && visited[j] == false && graph[num][j]<key[j]){
                    parent[j]=num;
                    key[j]=graph[num][j];
                }
            }
        }
        //print mst
        printmst(parent,graph);
    }

    private void printmst(int[] parent,int[][] graph){
        for(int i=1;i<graph.length;i++){
            System.out.println(parent[i]+" -> "+i+" "+graph[i][parent[i]]);
        }
    }
    
    private int minimumKey(int[] key, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minindex = -1;
        for(int i=0;i<key.length;i++){
            if(visited[i]==false && key[i]<min){
                min = key[i];
                minindex = i;
            }
        }
        return minindex;
    }
    
    public static void main(String[] sai){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices : ");
        int v = sc.nextInt();
        System.out.println("Enter the number of edges : ");
        int e = sc.nextInt();
        System.out.println("NOTE : edge numbering starts with ZERO (0)");
        int[][] graph = new int[v][v];
        for (int i = 0; i < e; i++) {
            //System.out.println("Enter the src, dest and cost for edge "+i);
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int cost = sc.nextInt();
            //System.out.println(src+" "+dest+" "+cost);
            graph[src][dest]=cost;
            graph[dest][src]=cost;
        }
        Prim prim = new Prim();
        prim.primexec(graph);
    }
}
