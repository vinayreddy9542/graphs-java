/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import static Graph.graph_addjacency_list.*;
import java.util.Stack;

/**
 *
 * @author reddy
 */
public class DFS {

    Stack<Integer> stk = new Stack<>();

    void displayvertex(int v) {
        System.out.print(vertex_list[v].label + " ");
    }

    void print() {
        vertex_list[0].visited = true;
        displayvertex(0);
        stk.push(0);
        while (!stk.isEmpty()) {
            int v = getadjvertex(stk.peek());
            if (v == -1) {
                stk.pop();
            } else {
                vertex_list[v].visited = true;
                displayvertex(v);
                stk.push(v);
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
