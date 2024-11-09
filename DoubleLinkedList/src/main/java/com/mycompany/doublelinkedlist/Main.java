/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.doublelinkedlist;

public class Main {

    public static void main(String[] args) {

        TwoWayChain<Integer> node1 = new TwoWayChain<>(5);
        TwoWayChain<Integer> node2 = new TwoWayChain<>(2);
        TwoWayChain<Integer> node3 = new TwoWayChain<>(1);
        TwoWayChain<Integer> node4 = new TwoWayChain<>(8);
        TwoWayChain<Integer> node5 = new TwoWayChain<>(3);
        TwoWayChain<Integer> node6 = new TwoWayChain<>(7);
        TwoWayChain<Integer> node7 = new TwoWayChain<>(14);
        TwoWayChain<Integer> node8 = new TwoWayChain<>(4);

        node1.insertAfter(node2);
        node2.insertAfter(node3);
        node3.insertAfter(node4);
        node4.insertAfter(node5);
        node5.insertAfter(node6);
        node6.insertAfter(node7);
        node7.insertAfter(node8);
        
        //Tablica Elementów TwoWayChain
        System.out.print("All elements in TwoWayChain \n");
        node1.PrintChain();
        
        
        //Wykonaj Operacje Matematyczną z Lambdy na elementach
        System.out.print("Multilpy all elements by 2 \n");
        TwoWayChain<Integer> resultChain = node1.doMathOperation(x -> x * 2);
        resultChain.PrintChain();
        
        
        //Pierwszy element w liście większy od 2 
        TwoWayChain<Integer> firstMatch = node1.searchFirstAppearance(data -> data > 2);
        if (firstMatch != null) {
            System.out.print("First found number bigger than 2 : " + firstMatch.Data + "\n");
        } else {
            System.out.println("No element found greater than 2");
        }
        
        
        //Znajdź wszystkie występujące elementy większe od 3
        int count = node1.countAppearance(data -> data > 3);
        System.out.println("Count of elements greater than 3: " + count + "\n");  // Expected: 2

        
        
        //Znajdź Wszystkie Parzyste
        System.out.print("Even Numbers in TwoWayChain \n");
        TwoWayChain<Integer> evenNumbers = node1.findAll(x -> x % 2 == 0);
        evenNumbers.PrintChain();

    }
}
