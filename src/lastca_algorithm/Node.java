/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lastca_algorithm;


/**
 *
 * @author altangerel
 */
//node class for binary tree that holds object and refernese to left and right chioldren
public class Node {
     Employee employee; // employee sorted in this node
    Node left, right;// references to left and right child nodes

    public Node(Employee employee) {
        this.employee = employee;
        left = right = null; // initializing left and right child as null
    }
    
}
