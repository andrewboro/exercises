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
		if ((current == null) || (current.getValue().compareTo(data) == 0)) {
			return current;
		}

		if (data.compareTo(current.getValue()) < 0) {
			return find(current.left, data);
		}

		return find(current.right, data);
	}

	public void remove(Node<T> toBeRemoved) {
		if (toBeRemoved == null)
			return;
		// has two children
		// has one child
		// has no children
		if (toBeRemoved.isLeaf()) {
			// if is root
			if (toBeRemoved == root) {
				root = null;
				return;
			}
			// find parent and null leaf
			Node<T> parent = findParent(root, toBeRemoved);
			if (parent.left == toBeRemoved) {
				parent.left = null;
			} else {
				parent.right = null;
			}

		} else if (toBeRemoved.hasTwoChildren()) {
			// find successor
			Node<T> successor = findSuccessor(root, toBeRemoved);
			toBeRemoved.value = successor.value;
			remove(successor);

		} else {
			// has one child
			// replace with child

			Node<T> temp = (null != toBeRemoved.left) ? toBeRemoved.left : toBeRemoved.right;

			toBeRemoved.value = temp.value;
			toBeRemoved.left = temp.left;
			toBeRemoved.right = temp.right;

		}

	}

	private Node<T> findParent(Node<T> current, Node<T> searchedFor) {
		if (current.left == searchedFor || current.right == searchedFor) {
			return current;
		} else {
			if (searchedFor.value.compareTo(current.value) < 0) {
				return findParent(current.left, searchedFor);
			} else {
				return findParent(current.right, searchedFor);
			}
		}
	}

	private Node<T> findSuccessor(Node<T> current, Node<T> searchedFor) {
		Node<T> successor = searchedFor.right;
		if (successor != null) {
			while (successor.left != null) {
				successor = successor.left;
			}
			return successor;
		}

		do {
			if (successor != null) {
				searchedFor = successor;
			}
			successor = findParent(current, searchedFor);
		} while (successor != null && successor.right == searchedFor);

		return successor;
	}

	public static <T extends Comparable<T>> int size(Node<T> current) {
		if (null == current) {
			return 0;
		}
		
		return 1 + size(current.left) + size(current.right);
	}

	public static <T extends Comparable<T>> int depth(Node<T> current) {
		if (current == null) {
			return 0;
		}
		return 1 + Math.max(depth(current.left), depth(current.right));
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

		System.out.println("Depth of the tree is: " + depth(tree.root));

		Node<Integer> toberemoved = tree.find(tree.root, new Integer(13));

		System.out.println("Found: " + toberemoved);

		tree.remove(toberemoved);
		System.out.println("Tree after removal");

		printTree(tree.root);
		
		System.out.println("Size of the tree: " + size(tree.root));
	}

}
