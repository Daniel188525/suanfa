package com.daniel.tree;

public class AVLTreeNode<T extends Comparable<T>> {

    public AVLTreeNode(T key, AVLTreeNode<T> left, AVLTreeNode<T> right) {
        this.key = key;
        this.left = left;
        this.right = right;
        this.height = 0;
    }

    /**
     * 关键字-用于排序
     */
    public T key;

    /**
     * 高度
     */
    public int height;

    /**
     * 左孩子
     */
    public AVLTreeNode<T> left;

    /**
     * 右孩子
     */
    public AVLTreeNode<T> right;

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public AVLTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(AVLTreeNode<T> left) {
        this.left = left;
    }

    public AVLTreeNode<T> getRight() {
        return right;
    }

    public void setRight(AVLTreeNode<T> right) {
        this.right = right;
    }
}
