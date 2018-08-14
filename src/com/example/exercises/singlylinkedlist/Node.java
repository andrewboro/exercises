package com.example.exercises.singlylinkedlist;

public class Node<T extends Comparable<T>> {
	T data;
	Node<T> next;

	public Node(Node<T> head, T data) {
		this.next = head;
		this.data = data;
	}

	Node<T> insertSorted(T data) {
		if (this.data.compareTo(data) > 0) {
			return new Node<>(this, data);
		}

		Node<T> current = this;
		while (current.next != null && current.next.data.compareTo(data) < 0) {
			current = current.next;
		}
		if (current.next == null) {
			current.next = new Node<>(null, data);
		} else {
			current.next = new Node<>(current.next, data);
		}

		return this;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node<T> current = this;
		while (current != null) {
			sb.append("Data: " + current.data + " -> ");
			current = current.next;
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Node<Integer> head = new Node<>(null, 12);
		head = new Node<>(head, 5);
		head = head.insertSorted(7);
		System.out.println(head);
		
		Node<Double> head2 = new Node<>(null, 1.23);
		head2 = new Node<>(head2, 1.0);
		head2 = head2.insertSorted(0.9);
		System.out.println(head2);
	}

}