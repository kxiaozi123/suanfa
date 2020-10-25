package com.imooc.test.array;

public class ArrayList {
    private int size;
    private int [] elements;
    private static final int DEFAULT_CAPACITY=10;
    private static final int ELEMENT_NOT_FOUND=-1;
    public ArrayList(int capacity)
    {
        capacity= Math.max(capacity, DEFAULT_CAPACITY);
        elements=new int[capacity];
    }
    public ArrayList()
    {
        this(DEFAULT_CAPACITY);
    }
    public int size()
    {
        return size;
    }
    public void clear()
    {
        size=0;
    }
    public boolean isEmpty()
    {
        return size==0;
    }
    public int get(int index)
    {
        if(index<0||index>=size)
        {
            throw new IndexOutOfBoundsException("Index:"+index+",Size:"+size);
        }
        return elements[index];
    }
    public int set(int index,int element)
    {
        if(index<0||index>=size)
        {
            throw new IndexOutOfBoundsException("Index:"+index+",Size:"+size);
        }
        int old = elements[index];
        elements[index]=element;
        return old;
    }
    public int indexOf(int element)
    {
        for (int i = 0; i < size; i++) {
            if(elements[i]==element) return i;
        }
        return ELEMENT_NOT_FOUND;
    }
    public boolean contains(int element)
    {
        return indexOf(element)!=ELEMENT_NOT_FOUND;
    }
    public static void main(String[] args) {
        ArrayList list=new ArrayList();
        list.get(-10);
    }
}
