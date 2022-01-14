package medium.q669.trimBST;

import java.util.LinkedList;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
      }
  }

public class Solution {
    public static TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null){
            return root;
        }
        if(root.val <low){
            root = root.right;
            trimBST(root, low, high);
        } else if(root.val >high){
            root = root.left;
            trimBST(root, low, high);
        } else{
            trimBST(root.left, low, high);
            trimBST(root.right,low, high);
        }
        return root;
    }

    public static void causeNull (TreeNode treeNode){
        treeNode = null;
    }

    public static void LaywerTraversal(TreeNode root){
                if(root==null) return;
                LinkedList<TreeNode> list = new LinkedList<TreeNode>();
                list.add(root);
                TreeNode currentNode;
               while(!list.isEmpty()){
                        currentNode=list.poll();
                        System.out.println(currentNode.val);
                      if(currentNode.left!=null){
                              list.add(currentNode.left);
                             }
                      if(currentNode.right!=null){
                               list.add(currentNode.right);
                            }
                    }
            }


    public static void main(String[] args) {
        TreeNode treeNode =new TreeNode(1);
        treeNode.left = new TreeNode(0);
        treeNode.right = new TreeNode(2);
        trimBST(treeNode,1,2);
        causeNull(treeNode);
        LaywerTraversal(treeNode);
     }
}
