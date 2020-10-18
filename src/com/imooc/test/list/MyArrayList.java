package com.imooc.test.list;



public class MyArrayList<E> {
    //两个成员变量 size 和elements
    private int size;
    private E[] elements;
    private static final int DEFAULT_CAPACITY = 10;
    private static final int ELEMENT_NOT_FOUND = -1;

    public MyArrayList(int capacity) {
        capacity = (Math.max(capacity, DEFAULT_CAPACITY));
        elements= (E[]) new Object[capacity];
    }

    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public int size() {
        return size;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(E element) {
        //包含的话 就是有索引
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    /**
     * 查看元素的索引
     *
     * @param element
     * @return
     */
    public int indexOf(E element) {
        if (element == null) {  // 1
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(elements[i])) return i; // n
            }
        }
        return ELEMENT_NOT_FOUND;

    }

    public void add(E element) {
//        elements[size] = element;
//        size++;
        add(size,element);
    }

    public E get(int index) {
        rangeCheck(index);
        return elements[index];

    }
    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            outOfBounds(index);
        }
    }
    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            outOfBounds(index);
        }
    }

    /**
     * 设置index位置的元素
     * @param index
     * @param element
     * @return 原来的元素ֵ
     */
    public E set(int index, E element) {
        rangeCheck(index);
        E old=elements[index];
        elements[index]=element;
        return old;
    }

    //数组下标越界错误
    private void outOfBounds(int index) {
        throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
    }
    /**
     * 删除index位置的元素
     * @param index
     * @return
     */
    public E remove(int index) {
        rangeCheck(index);
        E old=elements[index];
        for (int i = index+1; i <=size; i++) {
            elements[i-1]=elements[i];
        }
        size--;
        elements[size]=null;
        return old;

    }
    /**
     * 在index位置插入一个元素
     * @param index
     * @param element
     */
    public void add(int index, E element) {
       rangeCheckForAdd(index);
       //扩容
        ensureCapacity(size + 1);
        for (int i = size; i >index; i--) {
            elements[i+1]=elements[i];
        }
        elements[index]=element;
        size++;
    }
    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if(oldCapacity>=capacity) return;
        // 新容量为旧容量的1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i]=elements[i];
        }
        elements=newElements;

    }

    //数组toSting方法
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("size=").append(size).append(", [");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    //测试MyArrayList
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        list.add(1);
        /*list.add(1);
        list.add(2);
        list.add(0,5);
        System.out.println(list);*/
        //System.out.println(list.elements.length);
        //System.out.println(list);
    }
}
