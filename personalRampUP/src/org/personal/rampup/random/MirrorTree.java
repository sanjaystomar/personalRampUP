package org.personal.rampup.random;

import java.sql.SQLOutput;

public class MirrorTree {
    Node root;

    static class Node{
        int data;
        Node left,right;
    }

    static Node newNOde(int data){
        Node node = new Node();
        node.data = data;
        node.left=null;
        node.right=null;
        return node;

    }

    public static void main(String[] args) {
        MirrorTree tree = new MirrorTree();
        tree.root = newNOde(1);
        tree.root.left=newNOde(2);
        tree.root.right=newNOde(3);
        tree.root.left.left= newNOde(4);
        tree.root.left.right=newNOde(5);

        System.out.println("In order traversal of inplut tree is: ");
        tree.inOrder(tree.root);
        System.out.println("");
        tree.mirror(tree.root);

        System.out.println("Inordr traversal of mirrored tree is: ");
        tree.inOrder(tree.root);

    }

    private Node mirror(Node root){
        if(root== null){
            return null;
        }
        Node left= mirror(root.left);
        Node right = mirror(root.right);

        root.left=right;
        root.right=left;
        return root;
    }

    private void inOrder(Node root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.println(root.data + " " );
        inOrder(root.right);
    }
}
