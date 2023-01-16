# BinaryTree_Java

This library is designed to work with a binary tree.

## Tree

To create a Tree object, you need to initialize it, call the constructor from the "Tree" class.

```java
Tree tree = new Tree();
```

### Methods of the Tree class

| Method | Assignment | Use |
| - | - | - |
| setRootNode | Set the root of the tree. Returns a ```Tree``` object. | ```tree.setRootNode(node);``` |
| getRootNode | Get the root of the tree. Returns a ```Node``` object or ```null```. | ```tree.getRootNode();``` |
| findNode | Search for a node by value. Returns an object of type ```Node``` or ```null```. | ```tree.findNode(integer);``` |
| insertNode | Insert node by value. Returns a ```Tree``` object. | ```tree.insertNode(integer);``` |
| deleteNode | Delete node by value. Returns a ```Tree``` object. | ```tree.deleteNode(integer);``` |
| getMin | Get the minimum node from the tree. Returns a ```Node``` object. | ```tree.getMin();``` |
| getMax | Get the maximum node from the tree. Returns a ```Node``` object. | ```tree.getMax();``` |

## Node

Node class.

### Methods of the Node class
| Method | Assignment | Use |
| - | - | - |
| setValue | Sets the left child of the node. Returns a ```Node``` object. | ```node.setValue(integer);``` |
| setLeftChild | Sets the right child of the node. Returns a ```Node``` object. | ```node.setLeftChild(node);``` |
| setRightChild | Sets the value of the node. Returns a ```Node``` object. | ```node.setRightChild(node);``` |
| getValue | Getting the value of a node. Returns a ```int``` number. | ```node.getValue(node);``` |
| getLeftChild | Get the left child. Returns a ```Node``` object or ```null```. | ```node.getLeftChild(node);``` |
| getRightChild | Get the right child. Returns a ```Node``` object or ```null```. | ```node.getRightChild(node);``` |
