/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.doublelinkedlist;

public class Main {
    public static void main(String[] args) {
        TwoWayChain<Integer> node1 = new TwoWayChain<>(1);
        TwoWayChain<Integer> node2 = new TwoWayChain<>(2);
        TwoWayChain<Integer> node3 = new TwoWayChain<>(3);
        TwoWayChain<Integer> node4 = new TwoWayChain<>(4);

        node1.insertAfter(node2);
        node2.insertAfter(node3);
        node3.insertAfter(node4);

        // Search for the first element greater than 2
        TwoWayChain<Integer> firstMatch = node1.searchFirstAppearance(data -> data > 2);
        if (firstMatch != null) {
            System.out.println("First element greater than 2: " + firstMatch.Data);  // Expected: 3
        } else {
            System.out.println("No element found greater than 2");
        }

        // Count how many elements are greater than 2
        int count = node1.countAppearance(data -> data > 2);
        System.out.println("Count of elements greater than 2: " + count);  // Expected: 2
    }
}
