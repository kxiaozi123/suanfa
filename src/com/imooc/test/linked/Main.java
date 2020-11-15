package com.imooc.test.linked;

public class Main {
    public static void main(String[] args) {
        List<Integer> list=new SingleLinkedList2<>();
        list.add(20);
        list.add(0,10);
        list.add(30);
        list.add(list.size(),40);
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
        System.out.println(list.indexOf(10));
    }
}
