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
