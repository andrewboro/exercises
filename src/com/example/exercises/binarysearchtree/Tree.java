package com.example.exercises.binarysearchtree;

public class Tree<T extends Comparable<T>> {
	Node<T> root;

	public Node<T> insert(Node<T> current, T data) {
		if (root == null) {
			root = new Node<>(data);
			return root;
		}
		
		if (current == null) {
			return new Node<>(data);
		} else {
			if (data.compareTo(current.value) < 0) {
				current.left = insert(current.left, data);
			} else {
				current.right = insert(current.right, data);
			}
			return current;
		}
	}
	
	public Node<T> find(Node<T> current, T data) {
		if ((current == null) || (current.getValue().compareTo(data) == 0 )) {
			return current;
		}
		
		if (data.compareTo(current.getValue())< 0) {
			return find(current.left, data);
		}
		
		return find(current.right, data);
	}

	public static <T extends Comparable<T>> void printTree(Node<T> current) {

		if (current != null) {
			System.out.println(current);
			printTree(current.left);
			printTree(current.right);

		} else {
			return;
		}

	}

	public static void main(String[] args) {
		Tree<Integer> tree = new Tree<>();
		tree.insert(tree.root, new Integer(13));
		tree.insert(tree.root, new Integer(10));
		tree.insert(tree.root, new Integer(17));
		tree.insert(tree.root, new Integer(21));
		tree.insert(tree.root, new Integer(15));
		tree.insert(tree.root, new Integer(22));
		printTree(tree.root);
		
		Node<Integer> current = tree.root;
		Integer data = new Integer(21);
		Node<Integer> found = tree.find(current, data);
		
		System.out.println(found);
	}

	
}
