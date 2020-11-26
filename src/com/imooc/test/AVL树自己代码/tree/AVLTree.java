package com.imooc.test.AVL树自己代码.tree;



import java.util.Comparator;

public class AVLTree<E> extends BST<E> {
    public AVLTree() {
        this(null);
    }

    public AVLTree(Comparator<E> comparator) {
        super(comparator);
    }

    @Override
    protected void afterAdd(Node<E> node) {

    }

    @Override
    protected void afterRemove(Node<E> node) {
    }
    /*判断树是否平衡*/
    private boolean isBalanced(Node<E> node) {
        //avl树的平衡因子 绝对值 小一1
        return Math.abs(((AVLNode<E>)node).balanceFactor()) <= 1;
    }

    private void updateHeight(Node<E> node) {
        ((AVLNode<E>)node).updateHeight();
    }
    /*AVL 自己继承node*/
    private static class AVLNode<E> extends Node<E> {
        int height = 1;//创建出来的节点的高度就为1

        public AVLNode(E element, Node<E> parent) {
            super(element, parent);
        }
        /*计算平衡因子 实际就是左右高度之差*/
        public int balanceFactor() {
            int leftHeight = left == null ? 0 : ((AVLNode<E>)left).height;//把node强制转为成avlnode
            int rightHeight = right == null ? 0 : ((AVLNode<E>)right).height;
            return leftHeight-rightHeight;

        }
        public void updateHeight() {
            int leftHeight = left == null ? 0 : ((AVLNode<E>)left).height;//把node强制转为成avlnode
            int rightHeight = right == null ? 0 : ((AVLNode<E>)right).height;
            height=1+Math.max(leftHeight,rightHeight);
        }
        public Node<E> tallerChild() {
            int leftHeight = left == null ? 0 : ((AVLNode<E>)left).height;//把node强制转为成avlnode
            int rightHeight = right == null ? 0 : ((AVLNode<E>)right).height;
            if (leftHeight > rightHeight) return left;
            if (leftHeight < rightHeight) return right;
            //同方向的 如果自己是父节点的左  返回左
            return isLeftChild() ? left : right;
        }
    }
}
