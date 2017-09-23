import java.util.List;
import java.util.PriorityQueue;

public class Huffman {
    PriorityQueue<TreeNode> minQueue = new PriorityQueue<>();

    int last = 0;

    void onInit(List<Symbol> symbols) {
        for (Symbol sym : symbols) {
            TreeNode node = new TreeNode();
            node.symbol = sym.id;
            node.weight = sym.weight;
            node.left = null;
            node.right = null;
            minQueue.add(node);
            if (sym.id > last) {
                last = sym.id;
            }
        }
    }

    TreeNode encode() {
        while (minQueue.size() > 1) {
            TreeNode left = minQueue.poll();
            TreeNode right = minQueue.poll();
            TreeNode newNode = new TreeNode();
            newNode.weight = left.weight + right.weight;
            newNode.left = left;
            newNode.right = right;
            newNode.symbol = last++;
            minQueue.add(newNode);
        }
        return minQueue.poll();
    }

}
