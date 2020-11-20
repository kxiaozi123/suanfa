package com.imooc.test.队列复习.循环队列;
@SuppressWarnings("unchecked")
public class CircleQueue<E> {
    private int size;
    private int front;
    private E[] elements;
    private static final int DEFAULT_CAPACITY = 10;
    public CircleQueue()
    {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }
    public int size() {
       return size;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public void clear() {

    }

    public void enQueue(E element) {
        ensureCapacity(size+1);
        elements[index(size)]=element;
        size++;
    }

    public E deQueue() {
        E frontElement = elements[front];
        elements[front]=null;
        front=index(1);
        size--;
        return frontElement;
    }

    public E front() {
       return elements[front];
    }
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("capcacity=").append(elements.length)
                .append(" size=").append(size)
                .append(" front=").append(front)
                .append(", [");
        for (int i = 0; i < elements.length; i++) {
            if (i != 0) {
                string.append(", ");
            }

            string.append(elements[i]);
        }
        string.append("]");
        return string.toString();
    }

    private void ensureCapacity(int capacity) {
        //并不是每次都需要扩容
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;
        //扩容操作
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {  //这里的循环次数用size和oldCapacity都可以
            newElements[i] = elements[index(i)];
        }
        elements = newElements;
        front=0;

    }

    private int index(int index)
    {
        index=front+index;
        return index-(index>=elements.length? elements.length:0);
    }
}
