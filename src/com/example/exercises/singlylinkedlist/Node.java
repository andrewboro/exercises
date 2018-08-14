package com.example.exercises.singlylinkedlist;

public class Node<T extends Comparable<T>> {
	T data;
	Node<T> next;

	public Node(Node<T> next, T data) {
		this.next = next;
		this.data = data;
	}
}