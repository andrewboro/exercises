package com.example.exercises.singlylinkedlist;

public class List<T extends Comparable<T>> {
	Node<T> head;

	public void add(T data) {
		head = new Node<>(head, data);
		return;
	}

	public void insertSorted(T data) {
		if (head.data.compareTo(data) > 0) {
			head = new Node<>(head, data);
			return;
		}
		Node<T> current = head;
		while (current.next != null && current.next.data.compareTo(data) < 0) {
			current = current.next;
		}
		if (current.next == null) {
			current.next = new Node<>(null, data);
		} else {
			current.next = new Node<>(current.next, data);
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("HEAD -> ");
		Node<T> current = head;
		while (current != null) {
			sb.append("Data: " + current.data + " -> ");
			current = current.next;
		}
		sb.append("TAIL");
		return sb.toString();
	}

	public static void main(String[] args) {
		List<Integer> list = ListFactory.createSortedIntegerList();
		list.insertSorted(7);
		System.out.println(list);
	}
}
