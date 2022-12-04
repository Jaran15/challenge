/**
 * Challenge BST Autor: Joel Arancibia Mail. jaran15@hotmail.com Use JAVA 8 Was not use frameworks, no unit test since need for a faster implementation maven or
 * gradle.
 */

public class Main
{
  public static void main(String[] args)
  {
    System.out.println("Challenge BST - Joel Arancibia - jaran15@hotmail.com");

    //Test arrays
    int[] arrayTest1 = {12, 11, 90, 82, 7, 9};
    int[] arrayTest2 = {26, 82, 16, 92, 33};

    BinarySearchTree tree2 = new BinarySearchTree();

    tree2.insertArraytoNodes(arrayTest1);
    // print inorder traversal of the BST
    System.out.println("Array sorted: ");
    tree2.inorder();
    System.out.println("");
    // Calculating height of tree
    int levels2 = BinarySearchTree.height(tree2.getNode());
    System.out.println("Max level of Nodes: " + (levels2 - 1));
    // Printing the deepest node
    // Can be many Node if have same level of max tree
    System.out.println("Deep/es Nodes: ");
    tree2.deepestNode(tree2.getNode(), levels2);

    // Input 2
    BinarySearchTree tree3 = new BinarySearchTree();

    //Jump of line
    System.out.println("");
    System.out.println("");

    tree3.insertArraytoNodes(arrayTest2);
    // print inorder traversal of the BST
    System.out.println("Array sorted: ");
    tree3.inorder();
    System.out.println("");
    // Calculating height of tree
    int levels3 = BinarySearchTree.height(tree3.getNode());
    System.out.println("Max level of Nodes: " + (levels3 - 1));
    // Printing the deepest node
    // Can be many Node if have same level of max tree
    System.out.println("Deep/es Nodes: ");
    tree3.deepestNode(tree3.getNode(), levels3);
  }

}
