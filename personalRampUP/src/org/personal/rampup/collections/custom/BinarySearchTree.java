package org.personal.rampup.collections.custom;

public class BinarySearchTree {
    Node root = null;

    public void addNode(Integer e) {
        addNode(e, root);

    }

    private void addNode(Integer e, Node parentNode) {
        if (e == null) return;
        if (parentNode == null) {
            parentNode = new Node(e);
        } else {
            if(e < parentNode.element){
                addNode(e, parentNode.leftNode);
            } else if (e > parentNode.element){
                addNode(e, parentNode.rightNode);
            }
        }

    }

    public void removeNode(Integer e) {

    }

    private void removeNode(Node providedNode) {

    }

    public void printTree(){
        System.out.println(root.toString());
    }

    public Integer containsNode(Integer e) {
        return new Node(e).element;
    }

    static class Node {
        public Node(Integer element) {
            this.element = element;
        }

        Integer element;
        Node leftNode;
        Node rightNode;

        @Override
        public String toString() {
            return "Node{" +
                    "element=" + element +
                    ", leftNode=" + leftNode +
                    ", rightNode=" + rightNode +
                    '}';
        }
    }
}
