package bst;

import java.util.List;

public class BSTDemo {
    public static void main(String[] args) {
        BSTree bst = new BSTree();
//        bst.get(9);


        bst.insert(15);
        bst.insert(18);
        bst.insert(17);
        bst.insert(20);
        bst.insert(6);
        bst.insert(3);
        bst.insert(2);
        bst.insert(4);
        bst.insert(7);
        bst.insert(13);
        bst.insert(9);
        bst.inorder();

        int predecessor = bst.predecessor(17);
        System.out.println(predecessor);

        bst.remove(6);
        bst.inorder();
//        int minimum = bst.minimum();
//        System.out.println(minimum);

//        int successor = bst.successor(20);
//        System.out.println(successor);
//        int minimum = bst.minimum();
//        System.out.println(minimum);
//        int maximum = bst.maximum();
//        System.out.println(maximum);
//        int i = bst.get(6);
//        System.out.println(i);
//        int node = bst.get(11);
//        System.out.println(node);

    }
}
