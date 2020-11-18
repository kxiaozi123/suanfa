package com.imooc.test.数组;


import com.imooc.test.单链表.AbstractList;

/**
 * 有缩容操作
 *
 * @param <E>
 */
@SuppressWarnings("unchecked")
public class ArrayList2<E> extends AbstractList<E> {

    private E[] elements;
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayList2(int capacity) {
        capacity = Math.max(capacity, DEFAULT_CAPACITY);
        elements = (E[]) new Object[capacity];
    }

    public ArrayList2() {
        this(DEFAULT_CAPACITY);
    }

    public void clear() {
        //改成object 对象管理细节
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
        //缩容 仅供参考
        if (elements != null && elements.length > DEFAULT_CAPACITY) {
            elements = (E[]) new Object[DEFAULT_CAPACITY];
        }
    }

    /**
     * 复杂度O(1)  随机访问非常快
     *
     * @param index
     * @return
     */
    public E get(int index) {
        rangeCheck(index);
        return elements[index];
    }

    /**
     * 复杂度O(1)  随机访问非常快
     *
     * @param index
     * @return
     */
    public E set(int index, E element) {
        rangeCheck(index);
        E old = elements[index];
        elements[index] = element;
        return old;
    }

    public int indexOf(E element) {
        //空值的处理
        if (element == null) {
            for (int i = 0; i < size; i++) {
                //equal默认比较内存地址 如果重新了equal 方法 就用重写的方法比较
                //element为空 意味着 elements[i]找到空就行
                if (elements[i] == null) return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                //equal默认比较内存地址 如果重新了equal 方法 就用重写的方法比较
                //这里注意elements[i]可能会空指针
                if (element.equals(elements[i])) return i;

            }
        }
        return ELEMENT_NOT_FOUND;
    }

    /**
     * @param index
     * @return //时间复杂度
     * // 最好（ 往最后的位置添加元素 O(1)）
     * // 最坏(往最前面的位置添加元素 O(n))
     * // 平均  O(n)
     */
    public E remove(int index) {
        rangeCheck(index);
        E old = elements[index];
        for (int i = index + 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }
//        size--;
//        elements[size]=null;
        //最后一个设为null
        elements[--size] = null;
        //缩容操作
        trim();
        return old;
    }


    //注意 这里必须从大的位置开始挪动 如果从小的地方开始挪动 就会都被小的值给替换掉
    //时间复杂度
    // 最好（ 往最后的位置添加元素 O(1)）
    // 最坏(往最前面的位置添加元素 O(n))
    // 平均  O(n)
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        //至少保证size+1
        ensureCapacity(size + 1);

        /*for (int i = size-1; i >=index; i--) {
            elements[i+1]= elements[i];
        }
        elements[index]=element;*/
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];  //都是size-1的地方 移动给size
        }
        elements[index] = element;

        size++;
    }


    /**
     * 扩容操作
     * 复杂度震荡 举例 假设 默认容量为4 当添加第五个元素的时间 需要扩容 为8 添加后 时间复杂度 O（n）
     * 再执行删除操作 缩小到原来的一半 时间复杂度O（n)
     * PS ： 扩容的指数 和缩容的指数 相乘不为1 就不会出现 复杂度震荡问题
     *
     * @param capacity
     */
    private void ensureCapacity(int capacity) {
        //并不是每次都需要扩容
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;
        //扩容操作
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {  //这里的循环次数用size和oldCapacity都可以
            newElements[i] = elements[i];
        }
        elements = newElements;

    }

    //缩容操作
    private void trim() {
        int capacity = elements.length;
        //新的容量 缩小到原来的一半
        int newCapacity = capacity >> 1;
        // size 大于总容量的1/2 就不需要缩了
        // 而且必须大于默认容量 不然的话 会缩到很小 参考例子 12->6->3->1 然后再扩容 扩起来很麻烦
        if (size >= (newCapacity) || capacity <= DEFAULT_CAPACITY) return;
        //剩余的空间还有很多
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {  //这里的循环次数用size和oldCapacity都可以
            newElements[i] = elements[i];
        }
        elements = newElements;

    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("size=").append(size).append(", elements=[");
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(elements[i]);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        ArrayList2<Integer> list = new ArrayList2<>();
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
