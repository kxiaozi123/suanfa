package com.imooc.test.AVL树自己代码.tree;


import java.util.Comparator;

@SuppressWarnings("unchecked")
public class BST<E> extends BinaryTree<E> {
    private Comparator<E> comparator;

    public BST() {
        this(null);
    }

    public BST(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public boolean contains(E element) {
        return node(element) != null;
    }

    public void add(E element) {
        elementNotNullCheck(element);
        if (root == null) {
            root = createNode(element, null);
            size++;

            // 新添加节点之后的处理
            afterAdd(root);
            return;
        }
        // 添加的不是第一个节点
        // 找到父节点
        Node<E> parent = root;
        Node<E> node = root;
        int cmp = 0;
        while (node != null) {
            cmp = compare(element, node.element);
            parent = node;
            if (cmp > 0) {
                node = node.right;
            } else if (cmp < 0) {
                node = node.left;
            } else { // 相等
                node.element = element;
                return;
            }
        }
        Node<E> newNode = createNode(element, parent);
        if (cmp > 0) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }
        size++;
        // 新添加节点之后的处理
        afterAdd(newNode);
    }

    /**
     * 添加node之后的调整
     *
     * @param node 新添加的节点
     */
    protected void afterAdd(Node<E> node) {
    }

    public void remove(E element) {
        remove(node(element));
    }

    private void remove(Node<E> node) {
        if (node == null) return;
        size--;
        if (node.hasTwoChildren()) {
            Node<E> s = successor(node);
            node.element = s.element;
            node = s;
        }
        Node<E> replacement = node.left != null ? node.left : node.right;
        if (replacement != null)//度为1的情况
        {
            replacement.parent = node.parent;
            if (node.parent == null) {
                root = replacement;
            } else if (node == node.parent.left) {
                node.parent.left = replacement;
            } else {
                node.parent.right = replacement;
            }
            // 删除节点之后的处理
            afterRemove(node);
        } else if (node.parent == null) {
            root = null;
            // 删除节点之后的处理
            afterRemove(node);
        } else {//叶子节点
            if (node == node.parent.left) {
                node.parent.left = null;
            } else // node == node.parent.right
            {
                node.parent.right = null;
            }
            // 删除节点之后的处理
            afterRemove(node);
        }
    }
    /**
     * 删除node之后的调整
     * @param node 被删除的节点
     */
    protected void afterRemove(Node<E> node) { }

    /*根据值去查找node*/
    private Node<E> node(E element) {
        Node<E> node = root;
        while (node != null) {
            int cmp = compare(element, node.element);
            if (cmp == 0) return node;
            if (cmp > 0) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return null;
    }

    /**
     * @return 返回值等于0，代表e1和e2相等；返回值大于0，代表e1大于e2；返回值小于于0，代表e1小于e2
     */
    private int compare(E e1, E e2) { //comparator是外部的
        if (comparator != null) {
            return comparator.compare(e1, e2);
        }
        return ((Comparable<E>) e1).compareTo(e2);//comparable是类内部的
    }

    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not be null");
        }
    }
}
