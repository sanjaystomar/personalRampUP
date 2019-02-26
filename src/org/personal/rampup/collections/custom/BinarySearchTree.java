package org.personal.rampup.collections.custom;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
    private Node root = null;

    private int sizeOfTree;


    public BinarySearchTree() {
    }

    public void addNode(Integer e) {
        addNode(e, root);
    }


    private void addNode(Integer e, Node parentNode) {
        if (e == null) return;
        if (parentNode == null) {
            root = new Node(e);
        } else {
            if (e < parentNode.element) {
                if (parentNode.leftNode == null) {
                    parentNode.leftNode = new Node(e);
                    sizeOfTree++;
                } else {
                    addNode(e, parentNode.leftNode);
                }
            } else if (e > parentNode.element) {
                if (parentNode.rightNode == null) {
                    parentNode.rightNode = new Node(e);
                    sizeOfTree++;
                } else {
                    addNode(e, parentNode.rightNode);
                }
            }
        }

    }

    public void removeNode(Integer e) {
        removeNode(e, root, null);
    }

    private void removeNode(Integer e, Node node, Node parentNode) {

        if (node != null) {
            if (node.element == e) {
                checkTheRemovalScenario(node, parentNode);
            } else if (node.element > e) {
                removeNode(e, node.leftNode, node);
            } else if (node.element < e) {
                removeNode(e, node.rightNode, node);
            }
        }
    }

    private void checkTheRemovalScenario(Node node, Node parentNode) {
        if (parentNode == null) throw new IllegalArgumentException("No elements in tree");
//        Case 1: When the node to be deleted is a leaf node.
        if (node.leftNode == null && node.rightNode == null) {
            if (node.element < parentNode.element) {
                parentNode.leftNode = null;
                node = null;
            } else if (node.element > parentNode.element) {
                parentNode.rightNode = null;
                node = null;
            }
        }
//        Case 2: When the node to be deleted has one child node.
        else if (node.leftNode == null || node.rightNode == null) {
            if (node.leftNode == null) {
                if (node.element < parentNode.element) {
                    parentNode.leftNode = node.rightNode;
                    node = null;
                } else if (node.element > parentNode.element) {
                    parentNode.rightNode = node.rightNode;
                    node = null;
                }
            } else {
                if (node.rightNode == null) {
                    if (node.element < parentNode.element) {
                        parentNode.leftNode = node.leftNode;
                        node = null;
                    } else if (node.element > parentNode.element) {
                        parentNode.rightNode = node.leftNode;
                        node = null;
                    }
                }
            }
        }
//        Case 3: When the node to be deleted has two children node.
        else {

        }

    }

    public void printTree() {
        System.out.println(root);
    }

    public boolean containsNode(Integer e) {
        return containsNode(e, root);
    }

    public boolean containsNode(Integer e, Node node) {
        if (node != null) {
            if (node.element == e) {
                return true;
            } else if (node.element > e) {
                return containsNode(e, node.leftNode);
            } else if (node.element < e) {
                return containsNode(e, node.rightNode);
            }
        }
        return false;
    }

    static class Node {
        Node(Integer element) {
            this.element = element;
        }

        Integer element;
        Node leftNode;
        Node rightNode;

        @Override
        public String toString() {
            /*return element + " "
                    + "LChild :" + leftNode + " "
                    + "RChild :" + rightNode +" \n\t";*/
            return "Node{" +
                    "element=" + element +
                    ", leftNode=" + leftNode +
                    ", rightNode=" + rightNode +
                    '}';
        }

    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public int getSizeOfTree() {
        return sizeOfTree;
    }

    public void setSizeOfTree(int sizeOfTree) {
        this.sizeOfTree = sizeOfTree;
    }

}
