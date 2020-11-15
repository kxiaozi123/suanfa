package com.imooc.test.linked;

public abstract class AbstractList<E> implements List<E> {
    protected int size;
    protected void rangeCheck(int index) {
        if(index<0||index>=size)
        {
            OutOfBounds(index);
        }
    }
    protected void rangeCheckForAdd(int index) {
        if(index<0||index>size)
        {
            OutOfBounds(index);
        }
    }

    protected void OutOfBounds(int index) {
        throw new IndexOutOfBoundsException("Index:" + index + ",Size:" + size);
    }

    /**
     * 动态数组  最好情况 O(1)
     * 最坏情况O(n)  扩容的时候
     * 平均（均摊） O(1)  因为除了扩容的时候 其他情况都是O（1）
     * @param element
     */
    public void add(E element)
    {
        /*elements[size]=element;
        size++;*/
        //elements[size++]=element;
        add(size,element);
    }
    public boolean contains(E element)
    {
        return indexOf(element)!=ELEMENT_NOT_FOUND;
    }
    public int size()
    {
        return size;
    }
    public boolean isEmpty()
    {
        return size==0;
    }
}
