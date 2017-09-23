import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode implements Comparable<TreeNode> {
    public int symbol;
    public int weight;
    public TreeNode left;
    public TreeNode right;

    @Override
    public int compareTo(TreeNode o) {
        if (this.weight < o.weight)
            return -1;
        if (this.weight > o.weight)
            return 1;
        return 0;
    }


    List<Integer> getCodewordLengthLimits() {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        HashMap<Integer, Integer> depthMap = new HashMap<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        TreeNode root = this;
        nodeQueue.add(root);
        depthMap.put(root.symbol, 0);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            Integer nodeDepth = depthMap.get(node.symbol);
            int childDepth = nodeDepth + 1;
            if (node.left != null) {
                nodeQueue.add(node.left);
                depthMap.put(node.left.symbol, childDepth);
            }
            if (node.right != null) {
                nodeQueue.add(node.right);
                depthMap.put(node.right.symbol, childDepth);
            }
            if (node.left == null && node.right == null) {
                if (nodeDepth < min) {
                    min = nodeDepth;
                }
                if (nodeDepth > max) {
                    max = nodeDepth;
                }
            }
        }
        return Arrays.asList(min, max);
    }

}
