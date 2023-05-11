package Day6;


import java.util.*;

class NodeD {
    int val;
    NodeD left, right;
    NodeD(int val){
        this.val = val;
        left = null;
        right = null;
    }
}
class BSTD {
    NodeD root = null;
    BSTD(){

    }
    BSTD(NodeD root){
        root=root;
    }
    NodeD insert(NodeD root, int val){
        if(root == null){
            root = new NodeD(val);
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
    void print(NodeD root){
        System.out.print(root.val + " ");
        if(root.left != null){
            print(root.left);
        }
        if(root.right != null){
            print(root.right);
        }
    }
}

class SolutionD {
    public int getMin(NodeD root){
        if(root.left==null){
            return root.val;
        }
        return getMin(root.left);
    }
    public NodeD deleteNode(NodeD root, int val){
        // WRITE YOUR CODE HERE
        if(root==null){
            return null;
        }
        else if(val<root.val){
            root.left = deleteNode(root.left,val);
            return root;
        }
        else if(val>root.val){
            root.right = deleteNode(root.right,val);
            return root;
        }
        else{//root.val == val
            //this node should be deleted
            if(root.left==null && root.right==null){
                //it is a leaf node that we are deleting, simply return null
                return null;
            }
            else if(root.left!=null && root.right==null){
                //having only left child
                return root.left;
            }
            else if(root.left==null && root.right!=null){
                //having only right child
                return root.right;
            }
            else{
                //if both child is present
                int ideal = getMin(root.right); // ideal value can be left max or right min
                root.val = ideal;
                root.right = deleteNode(root.right,ideal);
                return root;
            }
        }
    }
}

public class DeleteBST {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), k = input.nextInt();
        BSTD t = new BSTD();
        for(int i = 0; i < n; i++){
            t.root = t.insert(t.root, input.nextInt());
        }
        SolutionD obj=new SolutionD();
        t.root= obj.deleteNode(t.root, k);
        t.print(t.root);
    }
}
