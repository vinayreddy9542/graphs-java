/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author reddy
 */
public class Kruskal {

    int v, e;
    Edge[] edge;

    Kruskal(int v, int e) {
        this.v = v;
        this.e = e;
        edge = new Edge[e];
        for (int i = 0; i < e; i++) {
            edge[i] = new Edge(0, 0, 0);
        }
    }

    private int find(subset[] subsets, int i) {
        if (subsets[i].parent != i) {
            subsets[i].parent = find(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }

    private void union(subset[] subsets, int x, int y) {
        int xr = find(subsets, x);
        int yr = find(subsets, y);
        if (subsets[xr].rank < subsets[yr].rank) {
            subsets[xr].parent = yr;
        } else if (subsets[xr].rank > subsets[yr].rank) {
            subsets[yr].parent = xr;
        } else {
            subsets[yr].parent = xr;
            subsets[xr].rank++;
        }
    }

    class CompareEdge implements Comparator<Edge> {

        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.cost - o2.cost;
        }

    }

    class subset {

        int parent, rank;
    }

    private void kruskalexec() {
        Edge result[] = new Edge[v];
        int j = 0, i = 0;
        for (i = 0; i < v; i++) {
            result[i] = new Edge(0, 0, 0);
        }
        CompareEdge compareedge = new CompareEdge();
        //sorting the edges based on the cost
        Arrays.sort(edge, compareedge);
        /*
        for(i=0;i<e;i++){
            System.out.println(edge[i].src+" "+edge[i].dest+" "+edge[i].cost);
        }
         */
        subset[] subsets = new subset[v];
        for (i = 0; i < v; i++) {
            subsets[i] = new subset();
        }
        for (i = 0; i < v; i++) {
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }
        i = 0;
        while (j < v - 1) {
            Edge ed = edge[i++];
            int x = find(subsets, ed.src);
            int y = find(subsets, ed.dest);
            if (x != y) {
                result[j++] = ed;
                union(subsets, x, y);
            }
        }
        //printing output
        System.out.println("Final edges that are present in MST are ");
        for (i = 0; i < j; i++) {
            System.out.println(result[i].src + " -> " + result[i].dest + " : " + result[i].cost);
        }
    }

    class Edge {

        int src, dest, cost;

        public Edge(int s, int d, int c) {
            src = s;
            dest = d;
            cost = c;
        }
    }

    public static void main(String[] sai) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices : ");
        int v = sc.nextInt();
        System.out.println("Enter the number of edges : ");
        int e = sc.nextInt();
        System.out.println("NOTE : edge numbering starts with ZERO (0)");
        Kruskal graph = new Kruskal(v, e);
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
        graph.kruskalexec();
    }
}
