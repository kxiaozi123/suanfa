package com.imooc.test.二叉搜索树;

import com.imooc.test.二叉搜索树.printer.BinaryTreeInfo;
import com.imooc.test.二叉搜索树.printer.BinaryTrees;

import java.nio.file.Files;
import java.util.Comparator;

public class Main {
    static void test1() {
        int[] data = new int[]{
                7, 4, 9, 2, 5
        };
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int datum : data) {
            bst.add(datum);
        }
        BinaryTrees.print(bst);
        //System.out.println(bst.isComplete());

        //BinaryTrees.print(bst);
//        System.out.println();
//        System.out.println("前序遍历");
//        bst.preorderTraversal();
//        System.out.println();
//        System.out.println("中序遍历");
//        bst.inorderTraversal();
//        System.out.println();
//        System.out.println("后序遍历");
//        bst.postorderTraversal();
        //System.out.println();
//        System.out.println("层序遍历");
//        bst.levelOrder(element -> {
//            System.out.print("_"+element+"_");
//        });
//        System.out.println();
//        bst.preorderTraversal(element -> {
//            System.out.print("_"+element+"_");
//        });
//        System.out.println();
//        bst.inorderTraversal(element -> {
//            System.out.print("_"+element+"_");
//        });
//        System.out.println();
//        bst.postorderTraversal(element -> {
//            System.out.print("_"+element+"_");
//        });
        //System.out.println(bst);
        //System.out.println(bst.height());



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
        System.out.println(bst.height());
    }


    public static void main(String[] args) {
        test1();
        //test2();
        //test3();


    }
}
