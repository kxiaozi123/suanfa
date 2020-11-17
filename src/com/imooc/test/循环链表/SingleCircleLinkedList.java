package com.imooc.test.循环链表;

import com.imooc.test.单链表.AbstractList;

/**
 * 单向循环链表
 *
 * @param <E>
 */
public class SingleCircleLinkedList<E> extends AbstractList<E> {
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
     *
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
     * * 时间复杂度  O(n)
     * * 最好 O(1)
     * * 最坏O(n)
     * * 平均O(n)
     * 网上说的链表添加复杂度为O（1） 实际上是指 添加那一时刻 指针的移动为O（1）
     *
     * @param index
     * @param element
     */
    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        if(index==0)
        {
            Node<E> newFirst=new Node<>(element,first);
            Node<E> last = (size==0)?newFirst:node(size - 1);
            last.next=newFirst;
            first=newFirst;
        }
        else {
            Node<E> prev = node(index - 1); //4  node为3
            prev.next=new Node<>(element,prev.next);
        }
//        if (index == 0) //添加到0这个位置 新创建的next 指向的就是当初的first
//        {
//            //这是单向链表有的
//            Node<E> newFirst = new Node<>(element, first);
//            //拿到最后一个节点
//            Node<E> last = (size==0)?newFirst:node(size-1);
//            last.next = newFirst;
//            first=newFirst;
//
//        } else {
//            Node<E> prev = node(index - 1); //考虑index=0的情况
//            prev.next = new Node<>(element, prev.next); //size位置的时候 prev.next 是null
//        }
        size++;
    }

    /**
     * * 时间复杂度  O(n)
     * * 最好 O(1)
     * * 最坏O(n)
     * * 平均O(n)
     *
     * @param index
     * @return
     */
    @Override
    public E remove(int index) {
        rangeCheck(index);
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
//        Node<E> node = first;
//        if(index==0)
//        {
//            first=first.next;
//        }
//        else {
//            Node<E> prev = node(index - 1);
//            node=prev.next;
//            prev.next=node.next;
//        }
//        if (index == 0) {
//            if(size==1)
//            {
//                first=null;
//            }
//            else {
//                //这句必须在first=first.next 前面 因为 node方法会用到first
//                Node<E> last = node(size - 1);
//                first = first.next;//这是单向链表有的
//                last.next=first;
//            }
//        } else {
//            Node<E> prev = node(index - 1);
//            node = prev.next;
//            prev.next = node.next;
//        }
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

        @Override
        public String toString() {
            StringBuilder sb=new StringBuilder();
            sb.append(element).append("_").append(next.element);
            return sb.toString();
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
            stringBuilder.append(node);
            node = node.next;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
