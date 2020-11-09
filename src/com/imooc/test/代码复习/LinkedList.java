package com.imooc.test.代码复习;

public class LinkedList<E> extends AbstractList<E> {
    private Node<E> first;
    private static class Node<E>
    {
        E element;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }
    @Override
    public void clear() {
        size=0;
        first=null;
    }

    @Override
    public E get(int index) {
        return node(index).element;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
        E old = node.element;
        node.element=element;
        return old;
    }

    @Override
    public void add(int index, E element) {
        if(index==0)
        {
            first=new Node<>(element,first);
        }
        else {
            Node<E> prev = node(index - 1);
            prev.next= new Node<>(element, prev.next);
        }
        size++;
    }

    @Override
    public E remove(int index) {
        Node<E> node=first;
        if(index==0)
        {
            first = first.next;
        }
        else {
            Node<E> prev = node(index - 1);
            node = prev.next;
            prev.next=node.next;
        }
        size--;
        return node.element;
    }

    @Override
    public int indexOf(E element) {
        //空值的处理
        if(element==null)
        {
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                //equal默认比较内存地址 如果重新了equal 方法 就用重写的方法比较
                //element为空 意味着 elements[i]找到空就行
                if(node.element==null) return i;
                node=node.next;
            }
        }
        else {
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                //equal默认比较内存地址 如果重新了equal 方法 就用重写的方法比较
                //这里注意elements[i]可能会空指针
                if(element.equals(node.element)) return i;
                node=node.next;

            }
        }
        return ELEMENT_NOT_FOUND;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("size=").append(size).append(", elements=[");
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            if(i!=0)
            {
                stringBuilder.append(",");
            }
            stringBuilder.append(node.element);
            node=node.next;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    private Node<E> node(int index)
    {
        rangeCheck(index);
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node=node.next;
        }
        return node;
    }

    public static void main(String[] args) {
        List<Integer> list=new LinkedList<>();
        list.add(20);
        list.add(0,10);
        list.add(30);
        list.add(list.size(),40);
        System.out.println(list);
        list.remove(1);
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println(list);
    }
}
