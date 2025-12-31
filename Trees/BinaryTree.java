import java.util.Random;

public class BinaryTree<E> {
       protected static class Node<E> {
              protected E data;
              protected Node<E> left;
              protected Node<E> right;

              public Node(E dataItem) {
                     data = dataItem;
                     left = null;
                     right = null;
              }

              public String toString() {
                     return data.toString();
              }
       }

       protected Node<E> root;

       public BinaryTree() {
              root = null;
       }

       public BinaryTree(Node<E> node) {
              root = node;
       }

       public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
              root = new Node<>(data);
              root.left = (leftTree == null) ? null : leftTree.root;
              root.right = (rightTree == null) ? null : rightTree.root;
       }

       public BinaryTree<E> getLeftSubtree() {
              return ((root != null && root.left != null) ? new BinaryTree<E>(root.left) : null);
              /*
               * if (root != null && root.left != null)
               * return new BinaryTree<E>(root.left);
               * else
               * return null;
               */
       }

       public BinaryTree<E> getRightSubtree() {
              return ((root == null || root.right == null) ? null : new BinaryTree<E>(root.right));
              /*
               * if (root == null || root.right == null)
               * return null;
               * else
               * return new BinaryTree<E>(root.right);
               */
       }

       public E getData() {
              return (root != null) ? root.data : null;
       }

       public boolean isLeaf() {
              return (root != null && (root.left == null && root.right == null));
       }

       public void preOrderTraverse() {
              preOrder(root);
       }

       protected void preOrder(Node<E> node) {
              if (node == null)
                     return;
              else {
                     System.out.print(node.data + " ");
                     preOrder(root.left);
                     preOrder(root.right);
              }
       }

       public void inOrderTraverse() {
              inOrder(root);
       }

       protected void inOrder(Node<E> node) {
              if (node == null)
                     return;
              else {
                     preOrder(root.left);
                     System.out.print(node.data + " ");
                     preOrder(root.right);
              }
       }

       public void postOrderTraverse() {
              postOrder(root);
       }

       protected void postOrder(Node<E> node) {
              if (node == null)
                     return;
              else {
                     preOrder(root.left);
                     preOrder(root.right);
                     System.out.print(node.data + " ");
              }
       }

       public void insertNode(E item) {
              Node<E> node = new Node<>(item);
              Node<E> parent = null, current;
              int randNum = 0;
              Random rand = new Random();
              if (root == null)
                     root = node;
              else {
                     current = root;
                     while (current != null) {
                            parent = current;
                            randNum = rand.nextInt(2);
                            if (randNum == 0)
                                   current = current.left;
                            else
                                   current = current.right;
                     }
                     if (randNum == 0)
                            parent.left = node;
                     else
                            parent.right = node;
              }
       }

       public int treeHeight() {
              return height(root);
       }

       private int height(Node<E> node) {
              if (node == null)
                     return 0;
              else
                     return (1 + max(height(node.left), height(node.right)));
       }

       private int max(int x, int y) {
              return (x >= y) ? x : y;
       }

       public int treeNodeCount() {
              return nodeCount(root);
       }

       private int nodeCount(Node<E> node) {
              if (node == null)
                     return 0;
              else
                     return (1 + nodeCount(node.left) + nodeCount(node.right));
       }

       public int countLeaf() {
              return countLeafNodes(root);
       }

       private int countLeafNodes(Node<E> node) {
              if (node == null)
                     return 0;
              if (node.left == null && node.right == null)
                     return 1;
              return countLeafNodes(node.left) + countLeafNodes(node.right);
       }

       public int countOne() {
              return countOneChild(root);
       }

       private int countOneChild(Node<E> node) {
              if (node == null)
                     return 0;
              else if ((node.left != null && node.right == null) || (node.left == null && node.right != null))
                     return (1 + countOneChild(node.left) + countOneChild(node.right));
              else
                     return countOneChild(node.left) + countOneChild(node.right);
       }

       public int countChild() {
              return countTwoChild(root);
       }

       private int countTwoChild(Node<E> node) {
              if (node == null)
                     return 0;
              if (node.left != null && node.right != null)
                     return (1 + countTwoChild(node.left) + countTwoChild(node.right));
              else
                     return countTwoChild(node.left) + countTwoChild(node.right);
       }

       public int findSum() {
              return sumAll(root);
       }

       private int sumAll(Node<E> node) {
              if (node == null)
                     return 0;
              else
                     return (Integer) node.data + sumAll(node.left) + sumAll(node.right);
       }

       public int countNon() {
              return countNonLeaf(root);
       }

       private int countNonLeaf(Node<E> node) {
              if (node == null)
                     return 0;
              if (node.left != null || node.right != null)
                     return (1 + countNonLeaf(node.left) + countNonLeaf(node.right));
              return countNonLeaf(node.left) + countNonLeaf(node.right);
       }

       public int countLeafOrLeft() {
              return countLeafOrLeftChild(root);
       }

       private int countLeafOrLeftChild(Node<E> node) {
              if (node == null)
                     return 0;
              else if ((node.left != null && node.right == null) || (node.left == null && node.right == null))
                     return 1 + countLeafOrLeftChild(node.left) + countLeafOrLeftChild(node.right);
              else
                     return countLeafOrLeftChild(node.left) + countLeafOrLeftChild(node.right);
       }

       public int sumNodesBT() {
              return sumNodesWithOneChild(root);
       }

       private int sumNodesWithOneChild(Node<E> node) {
              if (node == null)
                     return 0;
              else if ((node.left != null && node.right == null) || (node.left == null && node.right != null))
                     return (Integer) node.data;
              else
                     return sumNodesWithOneChild(node.left) + sumNodesWithOneChild(node.right);
       }

       public int SumLeafRight() {
              return SumLeafAndRChild(root);
       }

       private int SumLeafAndRChild(Node<E> node) {
              if (node == null)
                     return 0;
              else if ((node.left == null && node.right == null) || (node.left == null && node.right != null))
                     return (Integer) node.data + SumLeafAndRChild(node.right);
              else
                     return SumLeafAndRChild(node.left) + SumLeafAndRChild(node.right);
       }

       public int countDegreeBT() {
              return countDegree(root);
       }

       private int countDegree(Node<E> node) {
              if (node == null)
                     return 0;
              else if (node.left == null && node.right == null)
                     return 0;
              else if ((node.left != null && node.right == null) || (node.left == null && node.right != null))
                     return 1 + countDegree(node.left) + countDegree(node.right);
              else if (node.left != null && node.right != null)
                     return 2 + countDegree(node.left) + countDegree(node.right);
              else
                     return countDegree(node.left) + countDegree(node.right);
       }

       public int countOneChildLeaf() {
              return countOneChildLeafNodes(root);
       }

       private int countOneChildLeafNodes(Node<E> node) {
              if (node == null)
                     return 0;
              else if (node.left == null && node.right != null)
                     return 1 + countOneChildLeafNodes(node.right);
              else if (node.left != null && node.right == null)
                     return 1 + countOneChildLeafNodes(node.left);
              else if (node.left == null && node.right == null)
                     return 1;
              else
                     return countOneChildLeafNodes(node.left) + countOneChildLeafNodes(node.right);
       }
}
