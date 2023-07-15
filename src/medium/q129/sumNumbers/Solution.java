package medium.q129.sumNumbers;

import ez.treeNode.TreeNode;

class Solution {
    public int sumNumbers(TreeNode root) {
        return sum(root, root.val);
    }

    public int sum(TreeNode root, int sum){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return sum * 10 + root.val;
        }
        return sum(root.left, sum * 10 + root.val) + sum(root.right, sum * 10 + root.val);
    }
}