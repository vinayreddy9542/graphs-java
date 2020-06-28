/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

/**
 *
 * @author reddy
 */
public class graph_addjacency_list {

    static int total_vetex = 0;
    static Vertex[] vertex_list = new Vertex[20];
    static int ad_matrix[][] = new int[20][20];

    static void addvertex(String label) {
        vertex_list[total_vetex++] = new Vertex(label);
    }

    static void addedge(int start, int end) {
        ad_matrix[start][end] = 1;
        ad_matrix[end][start] = 1;
    }

    static void makevisitedfalse() {
        for (int i = 0; i < total_vetex; i++) {
            vertex_list[i].visited = false;
        }
    }

    public static void main(String[] sai) {
        addvertex("A");//0
        addvertex("B");//1
        addvertex("C");//2
        addvertex("D");//3
        addvertex("E");//4
        addvertex("F");//5

        addedge(0, 1);
        addedge(1, 2);
        addedge(0, 3);
        addedge(3, 4);
        addedge(4, 5);
        addedge(1, 3);

        DFS dfs = new DFS();
        BFS bfs = new BFS();

        System.out.println("DFS of the graph : ");
        if (total_vetex > 0) {
            dfs.print();
            makevisitedfalse();
        }
        System.out.println();
        System.out.println("BFS of the graph : ");
        if (total_vetex > 0) {
            bfs.print();
            makevisitedfalse();
        }
        System.out.println();
    }
}
