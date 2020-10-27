package com.imooc.test.array;


@SuppressWarnings("unchecked")
public class ArrayList<E> {
    private int size;
    private E [] elements;
    private static final int DEFAULT_CAPACITY=10;
    private static final int ELEMENT_NOT_FOUND=-1;
    public ArrayList(int capacity)
    {
        capacity= Math.max(capacity, DEFAULT_CAPACITY);
        elements= (E[]) new Object[capacity];
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
        //改成object 对象管理细节
        for (int i = 0; i < size; i++) {
            elements[i]=null;
        }
        size=0;
    }
    public boolean isEmpty()
    {
        return size==0;
    }
    public E get(int index)
    {
        rangeCheck(index);
        return elements[index];
    }
    public E set(int index,E element)
    {
        rangeCheck(index);
        E old = elements[index];
        elements[index]=element;
        return old;
    }
    public int indexOf(E element)
    {
        //空值的处理
        if(element==null)
        {
            for (int i = 0; i < size; i++) {
                //equal默认比较内存地址 如果重新了equal 方法 就用重写的方法比较
                //element为空 意味着 elements[i]找到空就行
                if(elements[i]==null) return i;
            }
        }
        else {
            for (int i = 0; i < size; i++) {
                //equal默认比较内存地址 如果重新了equal 方法 就用重写的方法比较
                //这里注意elements[i]可能会空指针
                if(element.equals(elements[i])) return i;

            }
        }
        return ELEMENT_NOT_FOUND;
    }
    public boolean contains(E element)
    {
        return indexOf(element)!=ELEMENT_NOT_FOUND;
    }
    public void add(E element)
    {
        /*elements[size]=element;
        size++;*/
        //elements[size++]=element;
        add(size,element);
    }
    public E remove(int index)
    {
        rangeCheck(index);
        E old = elements[index];
        for (int i = index+1; i <size; i++) {
            elements[i-1]=elements[i];
        }
//        size--;
//        elements[size]=null;
        //最后一个设为null
        elements[--size]=null;
        return old;
    }



    //注意 这里必须从大的位置开始挪动 如果从小的地方开始挪动 就会都被小的值给替换掉
    public void add(int index,E element)
    {
        rangeCheckForAdd(index);
        //至少保证size+1
        ensureCapacity(size+1);

        for (int i = size-1; i >=index; i--) {
            elements[i+1]= elements[i];
        }
        elements[index]=element;
        size++;
    }


    /**
     * 扩容操作
     * @param capacity
     */
    private void ensureCapacity(int capacity) {
        //并不是每次都需要扩容
        int oldCapacity = elements.length;
        if(oldCapacity>=capacity) return;
        //扩容操作
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E [] newElements= (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {  //这里的循环次数用size和oldCapacity都可以
            newElements[i]=elements[i];
        }
        elements=newElements;

    }

    private void rangeCheck(int index) {
        if(index<0||index>=size)
        {
            OutOfBounds(index);
        }
    }
    private void rangeCheckForAdd(int index) {
        if(index<0||index>size)
        {
            OutOfBounds(index);
        }
    }

    private void OutOfBounds(int index) {
        throw new IndexOutOfBoundsException("Index:" + index + ",Size:" + size);
    }

    @Override
    public String toString() {
       StringBuilder stringBuilder=new StringBuilder();
       stringBuilder.append("size=").append(size).append(", elements=[");
        for (int i = 0; i < size; i++) {
            if(i!=0)
            {
                stringBuilder.append(",");
            }
            stringBuilder.append(elements[i]);
        }
       stringBuilder.append("]");
       return stringBuilder.toString();
    }

    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();
//        list.add(0,120);
//        for (int i = 1; i <= 10; i++) {
//            list.add(i);
//        }
//        System.out.println(list);
        list.add(null);
        list.add(1);
        list.add(2);
        System.out.println(list);
        System.out.println(list.indexOf(1));
        //list.add(list.size(),120);
        //list.remove(8);
        //System.out.println(list);

    }
}
