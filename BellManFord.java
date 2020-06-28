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
public class BellManFord {
    int v,e;
    Edge[] edge;
    public BellManFord(int v,int e){
        this.v=v;
        this.e=e;
        edge = new Edge[e];
        for(int i=0;i<e;i++){
            edge[i] = new Edge();
        }
    }
    class Edge{
        int src,dest,cost;
        public Edge(){
            src=dest=cost=0;
        }
    }
    
    private void bellmanfordexec(BellManFord graph,int s){
        int[] distance = new int[v];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[s]=0;
        for(int i=1;i<v;i++){
            for(int j=0;j<e;j++){
                int src = graph.edge[j].src;
                int dest = graph.edge[j].dest;
                int cost = graph.edge[j].cost;
                if(distance[src] != Integer.MAX_VALUE && distance[src]+cost<distance[dest]){
                    distance[dest] = distance[src]+cost;
                }
            }
        }
        //printing
        bellmanfordprint(distance,s);
    }
    
    private void bellmanfordprint(int[] distance,int src){
        System.out.println("Distance from "+src+" to :");
        for(int i=0;i<distance.length;i++){
            System.out.println(i+" "+distance[i]);
        }
    }
    public static void main(String[] sai){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices : ");
        int v = sc.nextInt();
        System.out.println("Enter the number of edges : ");
        int e = sc.nextInt();
        System.out.println("NOTE : edge numbering starts with ZERO (0)");
        BellManFord graph = new BellManFord(v,e);
        for (int i = 0; i < e; i++) {
            //System.out.println("Enter the src, dest and cost for edge "+i);
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int cost = sc.nextInt();
            //System.out.println(src+" "+dest+" "+cost);
            graph.edge[i].cost = cost;
            graph.edge[i].src = src;
            graph.edge[i].dest = dest;
        }
        graph.bellmanfordexec(graph,0);
    }
}
