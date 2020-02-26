/**
 * Node for the binary tree.
 */
public class Node {

  // **** members ****
  double value;
  Node  left;
  Node  right;

  /**
   * Constructor.
   */
  public Node(double value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }

   /**
    * To string.
    */
  @Override
  public String toString() {
    return  "Node {" +
            " value: " + this.value + 
            "}";
  }
}