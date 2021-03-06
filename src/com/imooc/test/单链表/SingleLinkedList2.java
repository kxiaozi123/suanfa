package com.imooc.test.单链表;

/**
 * 虚拟头结点
 * PS: 这种写法不推荐
 *
 * @param <E>
 */
public class SingleLinkedList2<E> extends AbstractList<E> {
    private Node<E> first;

    public SingleLinkedList2() {
        first = new Node<>(null, null);
    }

    @Override
    public void clear() {
        size = 0;
        first = null;

    }

    @Override
    public E get(int index) {
        return node(index).element;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
        E old = node.element;
        node.element = element;
        return old;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);

        Node<E> prev = index == 0 ? first : node(index - 1); //考虑index=0的情况
        prev.next = new Node<>(element, prev.next); //size位置的时候 prev.next 是null

        size++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);

        Node<E> prev = index == 0 ? first : node(index - 1);
        Node<E> node = prev.next;
        prev.next = node.next;

        size--;
        return node.element;
    }

    @Override
    public int indexOf(E element) {
        //空值的处理
        if (element == null) {
            Node<E> node = first.next;
            for (int i = 0; i < size; i++) {
                //equal默认比较内存地址 如果重新了equal 方法 就用重写的方法比较
                //element为空 意味着 elements[i]找到空就行
                if (node.element == null) return i;
                node = node.next;
            }
        } else {
            Node<E> node = first.next;
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
        Node<E> node = first.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("size=").append(size).append(", elements=[");
        Node<E> node = first.next;
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
