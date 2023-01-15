package test;

public class Tree {
	private Node rootNode;
	
	public Node findNode(int value) {
		Node currentNode = rootNode;
		if (rootNode != null) {
			while (currentNode.getValue() != value) {
				if (value < currentNode.getValue()) currentNode = currentNode.getLeftChild();
				else currentNode = currentNode.getRightChild();
				if (currentNode == null) break;
			}
		}
		return currentNode;
	}
	
	public Tree insertNode(int value) {
		Node node = new Node().setValue(value);
		if (rootNode == null) rootNode = node;
		else {
			Node currentNode = rootNode;
			while (true) {
				if (value == currentNode.getValue()) break;
				if (value < currentNode.getValue()) {
					if (currentNode.getLeftChild() == null) {
						currentNode.setLeftChild(node);
						break;
					}
					currentNode = currentNode.getLeftChild();
				}
				else {
					if (currentNode.getRightChild() == null) {
						currentNode.setRightChild(node);
						break;
					}
					currentNode = currentNode.getRightChild();
				}
			}
		}
		return this;
	}
	
	public Tree setRootNode(Node node) {
		this.rootNode = node;
		return this;
	}

	public Node getRootNode() {
		return this.rootNode;
	}

	@Override
	public String toString() {
		return "Root node: " + this.rootNode;
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

	@Override
	public String toString() {
		return "{Value: " + this.value + "\nLeft child: " + this.leftChild + "\nRight child: " + this.rightChild + "}";
	}
}