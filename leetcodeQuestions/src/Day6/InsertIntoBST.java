package Day6;
//701. Insert into a Binary Search Tree
//https://leetcode.com/problems/insert-into-a-binary-search-tree/description/
//You are given the root node of a binary search tree (BST) and
//a value to insert into the tree. Return the root node of the BST
//after the insertion. It is guaranteed that the new value
//does not exist in the original BST.

import java.util.*;

class Node{
    int val;
    Node left, right;
    Node(int val){
        this.val = val;
        left = null;
        right = null;
    }
}
class BST{
    Node root = null;
    BST(){

    }
    BST(Node root){
        root=root;
    }
    Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(root.val == val)
            return root;
        if(val < root.val){
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }
        return root;
    }
    void print(Node root){
        System.out.print(root.val + " ");
        if(root.left != null){
            print(root.left);
        }
        if(root.right != null){
            print(root.right);
        }
    }
}

class Solution{
    public Node insertNode(Node root, int val){
        // WRITE YOUR CODE HERE
        if(root==null){
            Node nn = new Node(val);
            return nn;
        }
        if(root.val==val) return root;
        else if(val<root.val){
            root.left = insertNode(root.left,val);
        }
        else{
            root.right = insertNode(root.right,val);
        }
        return root;
    }
}

public class InsertIntoBST {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), k = input.nextInt();
        BST t = new BST();
        for(int i = 0; i < n; i++){
            t.root = t.insert(t.root, input.nextInt());
        }
        Solution obj=new Solution();
        t.root= obj.insertNode(t.root, k);
        t.print(t.root);
    }
}
