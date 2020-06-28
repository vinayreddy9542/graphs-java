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
public class Vertex {
    String label;
    boolean visited;

    public Vertex(String label) {
        this.label = label;
        visited = false;
    }
}
