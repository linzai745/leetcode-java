package bst;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BSTree {
    private Node root;

    public BSTree() {
        root = null;
    }

    public boolean remove(int key) {
        Node rmNode = get(key);

        if (rmNode == null) return false;

        if (rmNode.left == null) { //case1: 左子树为空，用右孩子替换
            transplant(rmNode, rmNode.right);
        } else if (rmNode.right == null) {//case2: 右子树为空，用右孩子替换
            transplant(rmNode, rmNode.left);
        } else { //case3: 左右子树都不为空
            Node successor = minimum(rmNode.right);

            if (successor.p != rmNode) { //后继结点不是rmNode的右孩子
                transplant(successor, successor.right);

                //将需要删除的目标节点的右子树作为successor的右子树
                successor.right = rmNode.right;
                successor.right.p = successor;
            }

            transplant(rmNode, successor);
            successor.left = rmNode.left;
            successor.left.p = successor;
        }

        return true;
    }

    private void transplant(Node replaceTarget, Node replace) {

        if (replaceTarget.p == null) {
            root = replace; //case1: repalceTarget 是根节点
        } else if (replaceTarget == replaceTarget.p.left) {
            replaceTarget.p.left = replace; //case2: 左孩子
        } else {
            replaceTarget.p.right = replace; //case3: 右孩子
        }

        if (replace != null) replace.p = replaceTarget.p;
    }

    /**
     * 查找val为key的节点的前驱节点
     * target = Node(key)
     *  1. 当Node(key)左子树不为空，它的前驱就是maximum(Node(key).left)
     *  2. 当Node(key)左子树为空，并且它有一个前驱y，y是target的最底层祖先，并且y的右孩子也是target的一个祖先。
     *      因此为了找到y，只需要从target节点往上查找，直到遇到一个节点-这个节点是其父节点的右孩子。
     *      如果key是树的最小节点，将会返回null。
     * @param key
     * @return
     */
    public int predecessor(int key) {
        Node target = get(key);

        //case 1
        if (target.left != null) {
            Node maxNode = maximum(target.left);
            return maxNode.val;
        }

        //case 2
        Node parent = target.p;
        while (parent != null && target == parent.left) {
            target = parent;
            parent = parent.p;
        }

        if (parent == null) throw new RuntimeException("Target node have not predecessor.");
        return parent.val;
    }

    public int successor(int key) {
        Node target = get(key);

        if (target.right != null) {
            Node minNode = minimum(target.right);
            return minNode.val;
        }

        Node p = target.p;
        while (p != null && target == p.right) {
            target = p;
            p = p.p;
        }

        if (p == null) throw new RuntimeException("Target node have not successor.");
        return p.val;
    }

    public int minimum() {
        Node node = minimum(root);
        return node.val;
    }

    private Node minimum(Node node) {
        Node curr = node;

        if (curr == null) throw new RuntimeException("Empty tree.");

        while (curr.left != null) {
            curr = curr.left;
        }

        return curr;
    }

    public int maximum(){
        Node node = maximum(root);
        return node.val;
    }

    private Node maximum(Node node) {
        Node curr = node;
        if (curr == null) throw new RuntimeException("Empty tree.");

        while (curr.right != null) {
            curr = curr.right;
        }

        return curr;
    }


    public void insert(int val) {
        Node y = null;
        Node x = root;
        Node newNode = new Node(val);

        while (x != null) {
            y = x;
            x = newNode.val > x.val ? x.right : x.left;
        }

        if (y == null) {
            root = newNode;
        } else if (newNode.val < y.val) {
            y.left = newNode;
        } else if (newNode.val > y.val){
            y.right = newNode;
        } else {
            System.out.println("[" + val + "] already exist.");
        }
        newNode.p = y;
    }

    public Node get(int key) {
        Node curr = root;

        while (curr != null && curr.val != key) {
            curr = key > curr.val ? curr.right : curr.left;
        }

        return curr;
    }

    public List<Integer> inorder() {
        List<Integer> result = new LinkedList<>();
        Deque<Node> stack = new LinkedList<>();

        Node curr = root;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                result.add(curr.val); //add after all left children
                curr = curr.right;
            }
        }
//        helper(this.root, result);
        System.out.println("Inorder: " + result);
        return result;
    }
//    private void helper(Node root, List<Integer> result) {
//        if (root == null) return;
//        helper(root.left, result);
//        result.add(root.val);
//        helper(root.right, result);
//    }

    static class Node {

        int val;
        Node left;
        Node right;
        Node p;

        Node(int val) {
            this.val = val;
            left = null;
            right = null;
            p = null;
        }
    }
}
