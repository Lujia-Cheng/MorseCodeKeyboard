package com.ayoitsluke.morsecodeime;

public class BinaryTree<T> {
    // TODO I only need a binary tree, not BST since letter will store left/right base on it's dit/dah

    /**
     * Represents nodes for a binary tree of arbitrary structure.
     *
     * @param <E> The type of data data contained in the tree.
     *            <p>
     */
    private class BinaryNode<E> {
        private E data;
        private BinaryNode<E> left;
        private BinaryNode<E> right;

        public BinaryNode(E newData) {
            this(newData, null, null);
        }

        public BinaryNode(E newData, BinaryNode<E> leftChild, BinaryNode<E> rightChild) {
            data = newData;
            left = leftChild;
            right = rightChild;
        }

        public E getData() {
            return data;
        }

        public void setData(E newData) {
            data = newData;
        }

        public BinaryNode<E> getLeft() {
            return left;
        }

        public void setLeft(BinaryNode<E> node) {
            left = node;
        }

        public BinaryNode<E> getRight() {
            return right;
        }

        public void setRight(BinaryNode<E> node) {
            right = node;
        }

        /**
         * Calculate the size of this binary tree.
         *
         * @return The size of this tree.
         */
        public int size() {
            return 1 + (left == null ? 0 : left.size()) + (right == null ? 0 : right.size());
        }

        /**
         * Calculate the height of this binary tree.
         * The height is longest path from the root to
         * a leaf node.
         * <p>
         * Examples:
         * A            A           A
         * |           / \
         * B          B   C
         * <p>
         * Height:
         * 2            2           1
         *
         * @return The height of this tree.
         */
        public int height() {
            return 1 + Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height());
        }
        
        public void insert(E newData, int[] dir) {
            // TODO decide which child (left or right) it should pass to

        }
    }

    private BinaryNode<T> root; // Root of the BST

    /**
     * Constructor
     */
    BinaryTree() {
        clear();
    }

    /**
     * Reinitialize tree
     */
    public void clear() {
        root = null;
    }

    public int size() {
        return root.size();
    }

    public int height() {
        return root.height();
    }

    /**
     * @param newData input data
     * @param dir     direction
     * @return
     */
    public boolean insert(T newData, int[] dir) {
        // TODO
        root.insert(newData, dir);
        return false;
    }

    public T remove(T e) {
        // TODO
        return null;
    }
}
