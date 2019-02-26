package org.personal.rampup.collections.custom;

public class TreeUsageMain {
    public static void main(String[] args) {
        BinarySearchTree btree = new BinarySearchTree();
        btree.addNode(5);
        btree.addNode(7);
        btree.addNode(8);
        btree.addNode(2);
        btree.addNode(10);
        btree.addNode(0);
        btree.addNode(6);
        btree.addNode(1);
        btree.addNode(13);
        btree.addNode(11);

        /*btree.addNode(13);
        btree.addNode(14);
        btree.addNode(18);
        btree.addNode(3);
        btree.addNode(4);
        btree.addNode(11);
        btree.addNode(61);*/
//        btree.addNode(14);


//        btree.printTree();


        System.out.println(btree.containsNode(7) + "##############");
        System.out.println(btree.containsNode(100) + "##############");
        btree.removeNode(11);

        TreeTraversal treeTraversal = new TreeTraversal(btree);
        System.out.println("Pre Order Traversal : " + treeTraversal.treeTraversalPreorder(btree));
        System.out.println("Post Order Traversal : " + treeTraversal.treeTraversalPostOrder(btree));
        System.out.println("In Order Traversal : " + treeTraversal.treeTraversalInorder(btree));

        System.out.println("BFS Traversal : " + treeTraversal.treeTraversalBFS(btree));
    }
}
