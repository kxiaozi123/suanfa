package com.imooc.test.二叉搜索树;

import com.imooc.test.二叉搜索树.printer.BinaryTreeInfo;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("unchecked")
public class BinarySearchTree<E> implements BinaryTreeInfo {
    private int size;
    private Node<E> root;
    private Comparator<E> comparator;
    public BinarySearchTree() {
        this(null);
    }

    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        root=null;
        size=0;
    }


    public void add(E element) {
        elementNotNullCheck(element);
        //添加第一个节点
        if (root == null) {
            root = new Node<>(element, null);
            size++;
            return;
        }
        //找到父节点
        Node<E> node = root;
        Node<E> parent = root;
        int cmp = 0;
        while (node != null) {
            //记录方向
            cmp = compare(element, node.element);
            //记录parent
            parent = node;
            if (cmp > 0) { //添加到右边
                node = node.right;
            } else if (cmp < 0) { //添加到左边
                node = node.left;
            } else { //相等
                node.element=element;
                return;
            }
        }
        //看看在父节点的哪个位置
        Node<E> newNode = new Node<>(element, parent);
        if (cmp > 0) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }
        size++;

    }

    public void remove(E element) {

    }

    public boolean contains(E element) {
        return true;
    }

    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((Node<E>)node).left;
    }

    @Override
    public Object right(Object node) {
        return ((Node<E>)node).right;
    }

    @Override
    public Object string(Object node) {
        Node<E> myNode= (Node<E>) node;
        String parentString="null";
        if(myNode.parent!=null)
        {
            parentString=myNode.parent.element.toString();
        }
        return myNode.element+"_p("+parentString+")";
    }

    private static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }
        public boolean isLeaf() {
            return left == null && right == null;
        }

        public boolean hasTwoChildren() {
            return left != null && right != null;
        }
    }

    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not be null");
        }
    }

    /**
     * @return 返回值等于0，代表e1和e2相等；返回值大于0，代表e1大于e2；返回值小于于0，代表e1小于e2
     */
    private int compare(E e1, E e2) {
        if (comparator != null) {
            return comparator.compare(e1, e2);
        }
        return ((Comparable<E>) e1).compareTo(e2);
    }
    /*不加visitor*/
    //    //	/**
////	 * 前序遍历
////	 */
//	public void preorderTraversal() {
//		preorderTraversal(root);
//	}
//
//	private void preorderTraversal(Node<E> node) {
//		if (node == null) return;
//
//		System.out.print(node.element+" ");
//		preorderTraversal(node.left);
//		preorderTraversal(node.right);
//	}
//    //	/**
////	 * 中序遍历
////	 */
//    public void inorderTraversal() {
//        inorderTraversal(root);
//    }
//
//    private void inorderTraversal(Node<E> node) {
//        if (node == null) return;
//
//        inorderTraversal(node.left);
//        System.out.print(node.element+" ");
//        inorderTraversal(node.right);
//    }
//    //	/**
////	 * 后序遍历
////	 */
//    public void postorderTraversal() {
//        postorderTraversal(root);
//    }
//
//    private void postorderTraversal(Node<E> node) {
//        if (node == null) return;
//
//        postorderTraversal(node.left);
//        postorderTraversal(node.right);
//        System.out.print(node.element+" ");
//    }
//    //	/**
////	 * 层序遍历
////	 */
//	public void levelOrderTraversal() {
//        if(root==null) return;
//        Queue<Node<E>> queue=new LinkedList<>();
//        queue.offer(root);
//        while (!queue.isEmpty())
//        {
//            Node<E> node = queue.poll();
//            System.out.print(node.element+" ");
//            if(node.left!=null)
//            {
//                queue.offer(node.left);
//            }
//            if(node.right!=null)
//            {
//                queue.offer(node.right);
//            }
//        }
//	}
    /**
     * 添加了visitor
     */
    public static interface Visitor<E>{
        void visit(E element);
    }
    public void levelOrder(Visitor<E> visitor) {
        if (root == null || visitor == null) return;

        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
//            if (visitor.visit(node.element)) return;
            visitor.visit(node.element);

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

        //	/**
//	 * 前序遍历
//	 */
	public void preorderTraversal(Visitor<E> visitor) {
		preorderTraversal(root,visitor);
	}

	private void preorderTraversal(Node<E> node,Visitor<E> visitor) {
		if (node == null||visitor==null) return;

		visitor.visit(node.element);
		preorderTraversal(node.left,visitor);
		preorderTraversal(node.right,visitor);
	}
    //	/**
//	 * 中序遍历
//	 */
    public void inorderTraversal(Visitor<E> visitor) {
        inorderTraversal(root,visitor);
    }

    private void inorderTraversal(Node<E> node,Visitor<E> visitor) {
        if (node == null||visitor==null) return;


        inorderTraversal(node.left,visitor);
        visitor.visit(node.element);
        inorderTraversal(node.right,visitor);
    }
    //	/**
//	 * 后序遍历
//	 */
    public void postorderTraversal(Visitor<E> visitor) {
        postorderTraversal(root,visitor);
    }

    private void postorderTraversal(Node<E> node,Visitor<E> visitor) {
        if (node == null||visitor==null) return;


        postorderTraversal(node.left,visitor);
        postorderTraversal(node.right,visitor);
        visitor.visit(node.element);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(root, sb, "");
        return sb.toString();
    }

    private void toString(Node<E> node, StringBuilder sb, String prefix) {
        if (node == null) return;
        toString(node.left, sb, prefix + "L---");
        sb.append(prefix).append(node.element).append("\n");
        toString(node.right, sb, prefix + "R---");
    }
    /*非递归方式算树的高度*/
    public int height() {
        if(root==null) return 0;
        int height=0;
        int levelSize=1;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            levelSize--;
            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
            if(levelSize==0){ //要访问下一层
                levelSize= queue.size();
                height++;
            }
        }
        return height;
    }
    /*是否为完全二叉树*/
    public boolean isComplete() {
        if(root==null) return false;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        boolean leaf = false;
        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            if(leaf&&!node.isLeaf()) return false;//要求是叶子节点，但它不是叶子节点
            if(node.hasTwoChildren()){
                queue.offer(node.left);
                queue.offer(node.right);
            }else if(node.left==null&&node.right!=null){
                return false;
            }else { //后面遍历的必须是叶子
                leaf=true;

            }
        }
        return true;
    }
    public int height2() {
        return height(root);
    }
    /*递归方式算 树的高度*/
    private int height(Node<E> node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }
    /*寻找前驱节点*/
    private Node<E> predecessor(Node<E> node){
        if(node==null) return null;
        Node<E> p = node.left;
        // 前驱节点在左子树当中（left.right.right.right....）
        if(p!=null)
        {
            while (p.right!=null)
            {
                p=p.right;
            }
            return p;
        }
        while (node.parent!=null&&node==node.parent.left)
        {
            node=node.parent;
        }
        return node.parent;
        //node.parent==null
        //node==node.paren.right
    }
    /*寻找后继节点*/
    private Node<E> successor(Node<E> node){
        if(node==null) return null;
        Node<E> p = node.right;
        // 前驱节点在左子树当中（right.left.left....）
        if(p!=null)
        {
            while (p.left!=null)
            {
                p=p.left;
            }
            return p;
        }
        while (node.parent!=null&&node==node.parent.right)
        {
            node=node.parent;
        }
        return node.parent;
        //node.parent==null
        //node==node.paren.left的就停止
    }
}
