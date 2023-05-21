package Part2;

import java.util.Iterator;
import java.util.Stack;

public class BinaryTree<T> implements Iterable<T> {
    private Node<T> root;

    private static class Node<T> {
        private T data;
        private Node<T> left;
        private Node<T> right;

        public Node(T data) {
            this.data = data;
        }
        public T getData() {
            return data;
        }
    }

    public BinaryTree(){
        this.root = null;
    }

    public BinaryTree(T rootData) {
        this.root = new Node<T>(rootData);
    }
    public BinaryTree(T rootData, BinaryTree<T> left, BinaryTree<T> right) {
        this.root = new Node<T>(rootData);
        root.left = left.root;
        root.right = right.root;
    }

    public void inorderTraverse (Visitor<T> visitor) {
        inorderTraverse(root, visitor);
    }

    public void inorderTraverse(Node<T> node, Visitor<T> visitor) {
        if (node != null) {
            inorderTraverse(node.left, visitor);
            visitor.visit(node.getData());
            inorderTraverse(node.right, visitor);
        }

    }
    public void postorderTraverse(Visitor<T> visitor) {
        postorderTraverse(root, visitor);
    }
    private void postorderTraverse (Node<T> node, Visitor<T> visitor) {
        if (node != null) {
            postorderTraverse(node.left, visitor);
            postorderTraverse(node.right, visitor);
            visitor.visit(node.data);
        }
    }

    public void preorderTraverse(Visitor<T> visitor) {
        preorderTraverse(root, visitor);
    }

    private void preorderTraverse(Node<T> node, Visitor<T> visitor) {
        if (node != null) {
            visitor.visit(node.data);
            preorderTraverse(node.left, visitor);
            preorderTraverse(node.right, visitor);
        }
    }



    public int getSize() {
        return getSizeOfNode(root);
    }

    private int getSizeOfNode(Node<T> node) {
        if (node == null) {
            return 0;
        }
        return 1 + getSizeOfNode(node.left) + getSizeOfNode(node.right);
    }

    @Override
    public Iterator<T> iterator() {
        return new InorderIterator<T>(root);
    }
    class InorderIterator<T> implements Iterator<T> {

        private Stack<Node<T>> stack = new Stack<>();

        public InorderIterator (Node<T> root) {
            pushUntilLeftest(root);
        }

        public void pushUntilLeftest(Node<T> node){
            while (node != null){
                stack.push(node);
                node = node.left;
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public T next() {
            Node<T> node = stack.pop();
            pushUntilLeftest(node.right);
            return node.getData();
        }
    }
}
