import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class Serialize {

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  @Test
  public void doIt() {
    String encoded1 = new Codec().serialize(null);
    System.out.println(encoded1);
    TreeNode tree1A = new Codec().deserialize(encoded1);

    TreeNode tree2 = new TreeNode(0);
    tree2.left = new TreeNode(1);
    tree2.right = new TreeNode(2);
    tree2.left.right = new TreeNode(3);
    tree2.right.left = new TreeNode(4);

    String encoded2 = new Codec().serialize(tree2);
    TreeNode tree2A = new Codec().deserialize(encoded2);
    System.out.println(encoded2);
  }

  public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
      StringBuilder sb = new StringBuilder();
      serialize(root, sb);
      return sb.toString();
    }

    private void serialize(TreeNode node, StringBuilder sb) {
      if (sb.length() != 0) {
        sb.append(",");
      }
      if (node == null) {
        sb.append("#");
        return;
      }
      sb.append(node.val);
      serialize(node.left, sb);
      serialize(node.right, sb);
    }


    public TreeNode deserialize(String data) {
      String[] split = data.split(",");
      return deserialize(split, new AtomicInteger());
    }

    private TreeNode deserialize(String[] split, AtomicInteger index) {
      String val = split[index.getAndIncrement()];
      if ("#".equals(val)) {
        return null;
      }
      TreeNode node = new TreeNode(Integer.parseInt(val));
      node.left = deserialize(split, index);
      node.right = deserialize(split, index);
      return node;
    }
  }

}
