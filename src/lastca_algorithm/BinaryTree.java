/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lastca_algorithm;

import java.util.List;

/**
 *
 * @author altangerel
 */
public class BinaryTree {
    Node root;

    public void insert(Employee emp) {
        root = insertRec(root, emp);
    }

    private Node insertRec(Node root, Employee emp) {
        if (root == null) return new Node(emp);
        if (emp.getSalary() < root.employee.getSalary()) root.left = insertRec(root.left, emp);
        else root.right = insertRec(root.right, emp);
        return root;
    }

    public void inOrder(List<Employee> list) {
        inOrderRec(root, list);
    }

    private void inOrderRec(Node root, List<Employee> list) {
        if (root != null) {
            inOrderRec(root.left, list);
            list.add(root.employee);
            inOrderRec(root.right, list);
        }
    }
    
}