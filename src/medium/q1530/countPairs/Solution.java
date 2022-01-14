package medium.q1530.countPairs;

/*unsolved*/
import java.util.ArrayList;
import java.util.List;

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

class Solution {
    public int countPairs(TreeNode root, int distance) {
        return 0;
    }

    private List<Integer> getDistances(TreeNode treeNode){
        List<Integer> disList = new ArrayList<>();
        if(treeNode.left!=null ){
            List<Integer> distances = getDistances(treeNode.left);
            for (int i = 0; i < distances.size(); i++) {
                distances.set(i,distances.get(i)+1);
            }
            disList.addAll(distances);
        }if(treeNode.right!=null ){
            List<Integer> distances = getDistances(treeNode.right);
            for (int i = 0; i < distances.size(); i++) {
                distances.set(i,distances.get(i)+1);
            }
            disList.addAll(distances);
        } else {
            disList.add(0);
        }
        return disList;
    }
}