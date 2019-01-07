package com.example.exercises.binarysearchtree;

public class Node<T extends Comparable<T>> {
	T value;
	Node<T> left;
	Node<T> right;

	Node(T data) {
		this.value = data;
	}

	boolean hasTwoChildren() {
		return (left != null && right != null);
	}

	boolean isLeaf() {
		return (left == null && right == null);
	}

	public T getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "Value: " + value.toString() + " Left: " + ((left == null) ? "null" : left.value.toString()) + " Right: " + ((right == null) ? "null" : right.value.toString());
	}
}