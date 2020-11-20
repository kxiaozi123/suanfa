package com.imooc.test.队列复习.循环队列;
@SuppressWarnings("unchecked")
public class CircleDeque<E> {
    private int size;
    private int front;
    private E[] elements;
    private static final int DEFAULT_CAPACITY = 10;
    public CircleDeque()
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

    public void enQueueRear(E element) {
        ensureCapacity(size+1);
        elements[index(size)]=element;
        size++;
    }

    public E deQueueFront() {
        E frontElement = elements[front];
        elements[front]=null;
        front=index(1);
        size--;
        return frontElement;
    }

    public void enQueueFront(E element) {
        ensureCapacity(size+1);
        front=index(-1);
        elements[front]=element;
        size++;

    }

    public E deQueueRear() {
        int rearIndex = index(size - 1);
        E element = elements[rearIndex];
        elements[rearIndex]=null;
        size--;
        return element;
    }

    public E front() {
       return elements[front];
    }

    public E rear() {
        return elements[index(size-1)];
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
        index+=front;
        if(index<0)
        {
            return index+ elements.length;
        }
        return index-(index>=elements.length? elements.length:0);
    }
}
