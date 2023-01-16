package test;

import static java.lang.System.out;

public class Tree {

	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.insertNode(7).insertNode(4).insertNode(3).insertNode(6).insertNode(5).insertNode(8).insertNode(10)
				.insertNode(9).insertNode(11);
		tree.deleteNode(10);
		out.println(tree.getRootNode());
	}

	private Node root;

	public Node findNode(int value) {
		Node current = root;
		if (root != null) {
			while (current.getValue() != value) {
				if (value < current.getValue())
					current = current.getLeftChild();
				else
					current = current.getRightChild();
				if (current == null)
					break;
			}
		}
		return current;
	}

	public Tree insertNode(int value) {
		Node node = new Node().setValue(value);
		if (root == null)
			root = node;
		else {
			Node current = root;
			while (true) {
				if (value == current.getValue())
					break;
				if (value < current.getValue()) {
					if (current.getLeftChild() == null) {
						current.setLeftChild(node);
						break;
					}
					current = current.getLeftChild();
				} else {
					if (current.getRightChild() == null) {
						current.setRightChild(node);
						break;
					}
					current = current.getRightChild();
				}
			}
		}
		return this;
	}

	public Tree deleteNode(int value) {
		if (root != null) {
			Node current = root;
			Node parent = root;
			boolean isLeftChild = false;
			while (current.getValue() != value) {
				parent = current;
				if (value < current.getValue()) {
					current = current.getLeftChild();
					isLeftChild = true;
				} else {
					current = current.getRightChild();
					isLeftChild = false;
				}
				if (current == null)
					return this;
			}
			if (current.getLeftChild() == null && current.getRightChild() == null) {
				if (current == root)
					root = null;
				else if (isLeftChild)
					parent.setLeftChild(null);
				else
					parent.setRightChild(null);
			} else if (current.getRightChild() == null) {
				if (current == root)
					root = current.getLeftChild();
				else if (isLeftChild)
					parent.setLeftChild(current.getLeftChild());
				else
					parent.setRightChild(current.getLeftChild());
			} else if (current.getLeftChild() == null) {
				if (current == root)
					root = current.getRightChild();
				else if (isLeftChild)
					parent.setLeftChild(current.getRightChild());
				else
					parent.setRightChild(current.getRightChild());
			} else {
				if (current == root) {
					root = current.getRightChild();
					root.getSuccessor().setLeftChild(current.getLeftChild());
				} else if (isLeftChild) {
					parent.setLeftChild(current.getRightChild());
					parent.getLeftChild().getSuccessor().setLeftChild(current.getLeftChild());
				} else {
					parent.setRightChild(current.getRightChild());
					parent.getRightChild().getSuccessor().setLeftChild(current.getLeftChild());
				}
			}
		}
		return this;
	}

	public Tree setRootNode(Node node) {
		this.root = node;
		return this;
	}

	public Node getRootNode() {
		return this.root;
	}

	@Override
	public String toString() {
		return "Root node: " + this.root;
	}
}

class Node {
	private int value;
	private Node leftChild;
	private Node rightChild;

	public Node setValue(int value) {
		this.value = value;
		return this;
	}

	public Node setLeftChild(Node node) {
		this.leftChild = node;
		return this;
	}

	public Node setRightChild(Node node) {
		this.rightChild = node;
		return this;
	}

	public int getValue() {
		return this.value;
	}

	public Node getLeftChild() {
		return this.leftChild;
	}

	public Node getRightChild() {
		return this.rightChild;
	}

	public Node getSuccessor() {
		Node temp = this;
		while (temp.getLeftChild() != null)
			temp = temp.getLeftChild();
		return temp;
	}

	@Override
	public String toString() {
		return "{Value: " + this.value + "\nLeft child: " + this.leftChild + "\nRight child: " + this.rightChild + "}";
	}
}