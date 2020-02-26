import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
*
*/
public class Solution {

  /**
   * Test scaffolding.
   * 
   * @throws IOException
   */
  public static void main(String[] args) throws IOException {
    
    // **** open a buffered reader ****
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
  
    // **** read the count of values to process ****
    int n = Integer.parseInt(bufferedReader.readLine());
  
    // ???? ????
    System.out.println("n: " + n);

    // **** read the values for the nodes and put them in a list ****
    List<Double> list = Stream.of(bufferedReader.readLine().split(" "))
                          .mapToDouble(Double::parseDouble)
                          .boxed()
                          .collect(Collectors.toList());

    // ???? ????
    System.out.println("list: " + list.toString());

    // **** instantiate a new empty tree ****
    BTree tree = new BTree();

    // *** loop inserting nodes into the tree ****
    double sum = 0.0;
    for (int i = 0; i < list.size(); i++) {

      // ???? ????
      sum += list.get(i);

      // **** insert this value into the binary tree ****
      tree.insert(tree.root, list.get(i));
    }

    // ???? ????
    System.out.println("sum: " + sum);

    // ???? inorder traversal of the tree ????
    System.out.print("inorder: ");
    tree.inorder(tree.root);
    System.out.println("\n");

    // **** sum the values of the nodes in the tree *****
    sum = tree.sum(tree.root);
    System.out.println("sum: " + sum);

    // **** specify range [LEFT : RIGHT] ****
    final double LEFT = 10.0;
    final double RIGHT = 15.0;
  
    // ???? ????
    System.out.println("LEFT: " + LEFT + " RIGHT: " + RIGHT);

    // **** sum the values of the nodes in the tree with inclusive constraints ****
    double sumInRange = tree.sumInRange(tree.root, LEFT, RIGHT);
    System.out.println("sumInRange: " + sumInRange);

    // **** close the buffered reader ****
    bufferedReader.close();
  }
}