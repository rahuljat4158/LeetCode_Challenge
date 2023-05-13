package Day8;

public class recoverBST {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {

        public class Pair{
            TreeNode node;
            int state;
            Pair(TreeNode node,int state){
                this.node = node;
                this.state = state;
            }
        }

        public TreeNode getNextInorder(Stack<Pair> st){
            while(st.size()>0){
                Pair top = st.peek();
                if(top.state==1){
                    top.state++;
                    if(top.node.left!=null) st.push(new Pair(top.node.left,1));
                }
                else if(top.state==2){
                    top.state++;
                    if(top.node.right!=null) st.push(new Pair(top.node.right,1));
                    return top.node;
                }
                else{
                    st.pop();
                }
            }
            return null;
        }

        public void recoverTree(TreeNode root) {
            Stack<Pair> st = new Stack<>();
            st.push(new Pair(root,1));
            TreeNode curr = getNextInorder(st);
            TreeNode prev = null;

            TreeNode a = null;
            TreeNode b = null;

            while(curr!=null){

                if(prev==null){

                    prev = curr;
                    curr = getNextInorder(st);
                }
                else{

                    if(prev.val>curr.val){

                        //a will be updated only once
                        if(a==null) a=prev;
                        //b will updated every time
                        b = curr;

                    }

                    //move prev and curr forward
                    prev = curr;
                    curr = getNextInorder(st);

                }
            }

            //swap the nodes
            int temp = a.val;
            a.val = b.val;
            b.val = temp;
        }
    }
}
