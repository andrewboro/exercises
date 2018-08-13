package com.example.exercises.singlylinkedlist;

public class Node {
	int data;
	Node next;

	Node(Node head, int data) {
		this.next = head;
		this.data = data;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node current = this;
		while (current != null) {
			sb.append("Data: " + current.data + " -> ");
			current = current.next;
		}
		return sb.toString();
	}

	Node insertSorted(int data) {
		if (this.data > data) {
			return new Node(this, data);
		}
		Node current = this;
		while (current.next != null && current.next.data < data) {
			current = current.next;
		}
		if (current.next == null) {
			current.next = new Node(null, data);
		} else {
			current.next = new Node(current.next, data);
		}

		return this;
	}

	public static void main(String[] args) {
		Node head = new Node(null, 12);
		head = new Node(head, 5);
		head = head.insertSorted(7);
		System.out.println(head);
	}
}