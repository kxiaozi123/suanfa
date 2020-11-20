package com.imooc.test.二叉搜索树;

import com.imooc.test.二叉搜索树.printer.BinaryTreeInfo;
import com.imooc.test.二叉搜索树.printer.BinaryTrees;

import java.nio.file.Files;
import java.util.Comparator;

public class Main {
    static void test1() {
        int[] data = new int[]{
                7, 4, 9, 2, 5, 8, 11, 3, 12, 1
        };
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int datum : data) {
            bst.add(datum);
        }
        BinaryTrees.print(bst);
    }
    static void test2() {
        Integer[] data = new Integer[] {
                7, 4, 9, 2, 5, 8, 11, 3, 12, 1
        };

        BinarySearchTree<Person> bst1 = new BinarySearchTree<>();
        for (Integer datum : data) {
            bst1.add(new Person(datum));
        }

        BinaryTrees.println(bst1);

        BinarySearchTree<Person> bst2 = new BinarySearchTree<>((o1, o2) -> o2.getAge() - o1.getAge());
        for (Integer datum : data) {
            bst2.add(new Person(datum));
        }
        BinaryTrees.println(bst2);
    }
    static void test3() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < 40; i++) {
            bst.add((int)(Math.random() * 100));
        }

//        String str = BinaryTrees.printString(bst);
//        str += "\n";
//        Files.writeToFile("F:/1.txt", str, true);

         BinaryTrees.println(bst);
    }


    public static void main(String[] args) {
        //test1();
        //test2();
        //test3();


    }
}
