package com.imooc.test.代码复习;



@SuppressWarnings("unchecked")
public class ArrayList<E> extends AbstractList<E> {
    private static final int DEFAULT_CAPACITY=10;
    private E [] elements;
    public ArrayList()
    {
        this(DEFAULT_CAPACITY);
    }
    public ArrayList(int capacity)
    {
        capacity= Math.max(capacity, DEFAULT_CAPACITY);
        elements= (E[]) new Object[capacity];
    }
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i]=null;
        }
        size=0;
    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        return elements[index];
    }

    @Override
    public E set(int index, E element) {
        rangeCheck(index);
        E old = elements[index];
        elements[index]=element;
        return old;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        //扩容
        ensureCapacity(size+1);
//        for (int i = size-1; i >= index; i--) {
//            elements[i+1]=elements[i];
//        }
        for (int i = size; i > index; i--) {
            elements[i]=elements[i-1];
        }
        elements[index]=element;
        size++;

    }

    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if(oldCapacity>=capacity) return;
        int newCapacity = oldCapacity + (oldCapacity >> 1);//这里的括号需要带上
        E [] newElements= (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i]=elements[i];
        }
        elements=newElements;
        System.out.println(oldCapacity+"扩容为"+newCapacity);

    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        E old = elements[index];
        for (int i = index+1; i < size; i++) {
            elements[i-1]=elements[i];
        }
//        size--;
//        elements[size]=null;
        elements[--size]=null;
        return old;
    }

    @Override
    public int indexOf(E element) {
        if(element==null)
        {
            for (int i = 0; i < size; i++) {
                if(elements[i]==null) return i;
            }
        }else {
            for (int i = 0; i < size; i++) {
                if(element.equals(elements[i])) return i;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("size=").append(size).append(",elements=[");
        for (int i = 0; i < size; i++) {
            if(i!=0){
                stringBuilder.append(",");
            }
            stringBuilder.append(elements[i]);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(20);
        list.add(0,10);
        list.add(30);
        list.add(list.size(),40);
        System.out.println(list);
        list.remove(1);
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println(list);
    }
}
