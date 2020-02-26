import java.util.List;

/**
 * Implements a binary tree of type Node.
 */
public class BTree {

  // **** root for a binary tree ****
  Node root = null;

  /**
   * Constructor without values.
   */
  public BTree () {
    this.root = null;
  }

  /**
   * Constructor with list of values.
   */
  public BTree(Node root, List<Double> list) {

    // ***** loop inserting nodes into the tree ****
    for (int i = 0; i < list.size(); i++) {
      insert(root, list.get(i));
    }

  }

  /**
   * Insert value into tree.
   * This is a recursive method.
   */
  public void insert(Node root, double v) {

    // **** add this node as the root of the tree ****
    if (root == null) {
      root = new Node(v);
      this.root = root;
      return;
    }

    // **** deal with the left child ****
    if (v <= root.value) {
      if (root.left == null) {
        root.left = new Node(v);
        return;
      } else {
        insert(root.left, v);
      }
    }

    // **** deal with the right child ****
    else {
      if (root.right == null) {
        root.right = new Node(v);
        return;
      } else {
        insert(root.right, v);
      }
    }
  }

  /**
   * In-order tree traversal.
   * This is a recursive call.
   */
  public void inorder(Node root) {
    if (root != null) {
      inorder(root.left);
      System.out.print(root.value + " ");
      inorder(root.right);
    }
  }

  /**
   * Sum the values of all the nodes in the tree.
   * This is a recursive call.
   */
  public double sum(Node root) {

    // **** for starters ****
    double s = 0.0;

    // **** end condition ****
    if (root == null) {
      return 0.0;
    }

    // **** value of current node ****
    s = root.value;

    // **** process left tree ****
    if (root.left != null) {
      s += sum(root.left);
    }

    // **** process right tree ****
    if (root.right != null) {
      s += sum(root.right);
    }

    // **** return sum ****
    return s;
  }

  /**
   * Sum values in range in the specified tree.
   * This is a recursive call.
   */
  public double sumInRange(Node root, double left, double right) {

    // **** for starters ****
    double s = 0.0;

    // **** end condition ****
    if (root == null) {
      return 0.0;
    }

    // **** add the value of current node (if needed) ****
    if ((root.value >= left) && (root.value <= right)) {
      s += root.value;
    }

    // **** add value from left node (if needed) ****
    if (root.left != null) {
      s += sumInRange(root.left, left, right);
    }

    // **** add value of right node (if needed) ****
    if (root.right != null) {
      s += sumInRange(root.right, left, right);
    }

    // **** return the sum ****
    return s;
  }
}