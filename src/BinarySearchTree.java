import java.util.Arrays;

class BinarySearchTree
{

  // Root of BST
  private Node root;

  BinarySearchTree()
  {
    root = null;
  }

  // If need Start with a value in a future
  BinarySearchTree(int value)
  {
    root = new Node(value);
  }

  //get Node root
  public Node getNode()
  {
    return root;
  }

  public Node clearNodes()
  {
    return root = null;
  }

  // This method mainly calls insertRec()
  public void insert(int key)
  {
    root = insertRec(root, key);
  }

  //  A recursive function to insert a new key in BST
  private Node insertRec(Node root, int key)
  {

    //  If the tree is empty, return a new node
    if (root == null)
    {
      root = new Node(key);
      return root;
    }
    // Otherwise, recur down the tree
    else if (key < root.key)
    {
      root.left = insertRec(root.left, key);
    }
    else if (key > root.key)
    {
      root.right = insertRec(root.right, key);
    }

    //return the (unchanged) node pointer
    return root;
  }

  // This method mainly calls InorderRec()
  public void inorder()
  {
    inorderRec(root);
  }

  // A utility function to do inorder traversal of BST
  private void inorderRec(Node root)
  {
    if (root != null)
    {
      inorderRec(root.left);
      System.out.print(root.key + " ");
      inorderRec(root.right);
    }
  }

  // Utility function to find height of a tree, rooted at 'root'.
  public static int height(Node root)
  {
    if (root == null)
    {
      return 0;
    }

    int leftHt = height(root.left);
    int rightHt = height(root.right);

    return Math.max(leftHt, rightHt) + 1;
  }

  // levels : current Level
  // Utility function to print all nodes at a given level.
  public void deepestNode(Node root, int levels)
  {
    if (root == null)
    {
      return;
    }

    if (levels == 1)
    {
      System.out.print(root.key + " ");
    }
    else if (levels > 1)
    {
      deepestNode(root.left, levels - 1);
      deepestNode(root.right, levels - 1);
    }
  }

  // iterative implementation
  //Public is need it to use for search in array
  public int binarySearch(int a[], int item, int low, int high)
  {
    while (low <= high)
    {
      int mid = low + (high - low) / 2;
      if (item == a[mid])
      {
        return mid + 1;
      }
      else if (item > a[mid])
      {
        low = mid + 1;
      }
      else
      {
        high = mid - 1;
      }
    }

    return low;
  }

  //Print array, might need it in future
  public void printarray(int array[])
  {
    for (int i = 0; i < array.length; i++)
    {
      System.out.print(array[i] + " ");
    }
  }

  //Add array to nodes
  public void insertArraytoNodes(int array[])
  {
    for (int i = 0; i < array.length; i++)
    {
      this.insert(array[i]);
    }
  }

  //delete a node from BST - Never used but part of BST methods need unit test if necessary
  public void deleteKey(int key)
  {
    root = deleteRecursive(root, key);
  }

  private int minValue(Node root)
  {
    //initially minval = root
    int minval = root.key;
    //find minval
    while (root.left != null)
    {
      minval = root.left.key;
      root = root.left;
    }
    return minval;
  }

  //recursive delete function
  private Node deleteRecursive(Node root, int key)
  {
    //tree is empty
    if (root == null)
    {
      return root;
    }

    //traverse the tree
    if (key < root.key)     //traverse left subtree
    {
      root.left = deleteRecursive(root.left, key);
    }
    else if (key > root.key)  //traverse right subtree
    {
      root.right = deleteRecursive(root.right, key);
    }
    else
    {
      // node contains only one child
      if (root.left == null)
      {
        return root.right;
      }
      else if (root.right == null)
      {
        return root.left;
      }

      // node has two children;
      // get inorder successor (min value in the right subtree)
      root.key = minValue(root.right);

      // Delete the inorder successor
      root.right = deleteRecursive(root.right, root.key);
    }
    return root;
  }

  //  Class containing left and right child of current node and key value
  class Node
  {
    private int key;
    private Node left, right;

    private Node(int item)
    {
      key = item;
      left = right = null;
    }

    // Might be need it in future
    public int getNodeKey()
    {
      return key;
    }
  }
}
