package org.personal.rampup.collections.custom;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeTraversal {

    public TreeTraversal(BinarySearchTree btree) {
        this.btree = btree;
    }

    // ## fields ##
    private List<Integer> preOrderTraversalList = new ArrayList<>();
    private List<Integer> postOrderTraversalList = new ArrayList<>();
    private List<Integer> inOrderTraversalList = new ArrayList<>();

    private List<Integer> bfsTraversalList = new ArrayList<>();

    private BinarySearchTree btree;

    // ## methods ##
    public List<Integer> treeTraversalPreorder(BinarySearchTree bTree) {
        return treeTraversalPreorder(bTree, bTree.getRoot());
    }

//    DFS Tree Traversals

    public List<Integer> treeTraversalPreorder(BinarySearchTree bTree, BinarySearchTree.Node node) {
        if (node != null) {
            preOrderTraversalList.add(node.element);
            treeTraversalPreorder(bTree, node.leftNode);
            treeTraversalPreorder(bTree, node.rightNode);
        }
        return preOrderTraversalList;
    }

    public List<Integer> treeTraversalPostOrder(BinarySearchTree bTree) {
        return treeTraversalPostOrder(bTree, bTree.getRoot());
    }

    public List<Integer> treeTraversalPostOrder(BinarySearchTree bTree, BinarySearchTree.Node node) {
        if (node != null) {
            treeTraversalPostOrder(bTree, node.leftNode);
            treeTraversalPostOrder(bTree, node.rightNode);
            postOrderTraversalList.add(node.element);
        }
        return postOrderTraversalList;
    }

    public List<Integer> treeTraversalInorder(BinarySearchTree btree) {
        return treeTraversalInorder(btree, btree.getRoot());
    }

    public List<Integer> treeTraversalInorder(BinarySearchTree btree, BinarySearchTree.Node node) {
        if (node != null) {
            treeTraversalInorder(btree, node.leftNode);
            inOrderTraversalList.add(node.element);
            treeTraversalInorder(btree, node.rightNode);
        }
        return inOrderTraversalList;
    }

    //    BFS Tree Traversals
    public List<Integer> treeTraversalBFS(BinarySearchTree btree) {
        return treeTraversalBFS(btree, btree.getRoot());
    }

    private Queue<BinarySearchTree.Node> bfsGenerationQueue = new LinkedList<>();

    private List<Integer> treeTraversalBFS(BinarySearchTree btree, BinarySearchTree.Node node) {
//            if(bfsGenerationQueue.isEmpty() && ){}
        if (node != null) {
            bfsTraversalList.add(node.element);
            bfsGenerationQueue.add(node);
            while (!bfsGenerationQueue.isEmpty()) {
                BinarySearchTree.Node curNode = bfsGenerationQueue.poll();
                if (curNode.leftNode != null) {
                    bfsTraversalList.add(curNode.leftNode.element);
                    bfsGenerationQueue.add(curNode.leftNode);
                }
                if (curNode.rightNode != null) {
                    bfsTraversalList.add(curNode.rightNode.element);
                    bfsGenerationQueue.add(curNode.rightNode);
                }
            }
        }
        return bfsTraversalList;
    }
}
