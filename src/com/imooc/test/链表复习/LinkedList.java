package com.imooc.test.链表复习;

import com.imooc.test.单链表.AbstractList;

/**
 * gc root 对象 被栈指针（局部变量）指向的对象
 * 双向链表对比 单向链表 操作数量节省了一半
 * 总结：
 * 如果你频繁在尾部添加、删除 元素 双向链表、动态数组都可以
 * 如果你在首部添加、删除 用双向链表
 * 如果你在任意位置 添加、删除元素 用双向链表
 * 频繁查询 用动态数组
 *
 * @param <E>
 */
public class LinkedList<E> extends AbstractList<E> {
    private Node<E> first;
    private Node<E> last;

    @Override
    public void clear() {
        size = 0;
        first = null;
        last = null;

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
        if(index==size)
        {
            Node<E> oldLast = last;
            last=new Node<>(oldLast,element,null);
            if(oldLast==null)
            {
                first=last;
            }
            else {
                oldLast.next=last;
            }
        }
        else {
            Node<E> next = node(index);
            Node<E> prev = next.prev;
            Node<E> node = new Node<>(prev, element, next);
            next.prev=node;
            if(prev==null)
            {
                first=node;
            }
            else {
                prev.next=node;
            }
        }

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
        Node<E> node = node(index);
        Node<E> prev = node.prev;
        Node<E> next = node.next;
        if(prev==null)
        {
            first=next;
        }
        else {
            prev.next=next;
        }
        if(next==null)
        {
            last=prev;
        }else {
            next.prev=prev;
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
        Node<E> prev;
        Node<E> next;

        public Node(Node<E> prev, E element, Node<E> next) {
            this.prev = prev;
            this.element = element;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (prev != null) {
                sb.append(prev.element);
            } else {
                sb.append("null");
            }
            sb.append("_").append(element).append("_");
            if (next != null) {
                sb.append(next.element);
            } else {
                sb.append("null");
            }
            return sb.toString();
        }
    }

    private Node<E> node(int index) {
        rangeCheck(index);
        if (index < (size >> 1)) {
            Node<E> node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else {
            Node<E> node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
            return node;
        }
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
