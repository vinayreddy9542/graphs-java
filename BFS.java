/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import static Graph.graph_addjacency_list.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author reddy
 */
public class BFS {

    Queue<Integer> que = new LinkedList<>();

    void displayvertex(int v) {
        System.out.print(vertex_list[v].label + " ");
    }

    void print() {
        vertex_list[0].visited = true;
        que.add(0);
        displayvertex(0);
        int v2;
        while (!que.isEmpty()) {
            int v1 = que.poll();
            while ((v2 = getadjvertex(v1)) != -1) {
                vertex_list[v2].visited = true;
                displayvertex(v2);
                que.add(v2);
            }
        }
    }

    private int getadjvertex(int peek) {
        for (int i = 0; i < total_vetex; i++) {
            if (ad_matrix[peek][i] == 1 && vertex_list[i].visited == false) {
                return i;
            }
        }
        return -1;
    }
}
