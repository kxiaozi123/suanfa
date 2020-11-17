package com.imooc.test.单链表;
public class SingleLinkedList<E> extends AbstractList<E> {
    private Node<E> first;

    @Override
    public void clear() {
        size = 0;
        first = null;

    }

    /**
     * 时间复杂度  O(n)
     * 最好 O(1)
     * 最坏O(n)
     * 平均O(n)
     *
     * @param index
     * @return
     */
    @Override
    public E get(int index) {
        return node(index).element;
    }

    /**
     * * 时间复杂度  O(n)
     * * 最好 O(1)
     * * 最坏O(n)
     * * 平均O(n)
     * @param index
     * @param element
     * @return
     */
    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
        E old = node.element;
        node.element = element;
        return old;
    }

    /**
     *  * 时间复杂度  O(n)
     *      * 最好 O(1)
     *      * 最坏O(n)
     *      * 平均O(n)
     *      网上说的链表添加复杂度为O（1） 实际上是指 添加那一时刻 指针的移动为O（1）
     * @param index
     * @param element
     */
    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        if(index==0)
        {
            first=new Node<>(element,first);
        }else {
            Node<E> prev = node(index - 1);
            prev.next=new Node<>(element,prev.next);
        }
//        if (index == 0) //添加到0这个位置 新创建的next 指向的就是当初的first
//        {
//            first = new Node<>(element, first);
//        } else {
//            Node<E> prev = node(index - 1); //考虑index=0的情况
//            prev.next = new Node<>(element, prev.next); //size位置的时候 prev.next 是null
//        }
        size++;
    }

    /**
     *  * 时间复杂度  O(n)
     *      * 最好 O(1)
     *      * 最坏O(n)
     *      * 平均O(n)
     * @param index
     * @return
     */
    @Override
    public E remove(int index) {
        rangeCheck(index);
//        Node<E> node = first;
//        if (index == 0) {
//            first = first.next;
//        }else {
//            Node<E> prev = node(index - 1);
//            node=prev.next;
//            prev.next=node.next;
//        }
        Node<E> node = first;
        if(index==0)
        {
            first=first.next;
        }
        else {
            Node<E> prev = node(index - 1);
            node=prev.next;
            prev.next=node.next;
        }

        size--;
        return node.element;
    }

    @Override
    public int indexOf(E element) {
        //空值的处理
        if (element == null) {
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                //equal默认比较内存地址 如果重新了equal 方法 就用重写的方法比较
                //element为空 意味着 elements[i]找到空就行
                if (node.element == null) return i;
                node = node.next;
            }
        } else {
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                //equal默认比较内存地址 如果重新了equal 方法 就用重写的方法比较
                //这里注意elements[i]可能会空指针
                if (element.equals(node.element)) return i;
                node = node.next;

            }
        }
        return ELEMENT_NOT_FOUND;
    }

    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    private Node<E> node(int index) {
        rangeCheck(index);
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("size=").append(size).append(", elements=[");
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(node.element);
            node = node.next;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
