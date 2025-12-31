public class BST<E extends Comparable<E>> extends BinaryTree<E> {
       private int size;

       public BST() {
              root = null;
              size = 0;
       }

       public boolean isEmpty() {
              return size == 0;
       }

       public int size() {
              return size;
       }

       public boolean contains(E key) {
              return contains(root, key);
       }

       private boolean contains(Node<E> node, E key) {
              if (node == null)
                     return false;
              int cmp = key.compareTo(node.data);
              if (cmp == 0)
                     return true;
              return ((cmp < 0) ? contains(node.left, key) : contains(node.right, key));
       }

       public boolean search(E item) {
              if (root == null)
                     return false;
              Node<E> cur = root;
              while (cur != null) {
                     if (cur.data.equals(item))
                            return true;
                     else if (cur.data.compareTo(item) < 0)
                            cur = cur.left;
                     else
                            cur = cur.right;
              }
              return false;
       }

       public void insert(E key) {
              root = insert(root, key);
       }

       private Node<E> insert(Node<E> node, E key) {
              if (node == null) {
                     size++;
                     return new Node<>(key);
              }
              int cmp = key.compareTo(node.data);
              if (cmp < 0)
                     node.left = insert(node.left, key);
              else if (cmp > 0)
                     node.right = insert(node.right, key);
              return node;
       }

       public void delete(E key) {
              root = delete(root, key);
       }

       private Node<E> delete(Node<E> node, E key) {
              if (node == null)
                     return null;
              int cmp = key.compareTo(node.data);
              if (cmp < 0)
                     node.left = delete(node.left, key);
              else if (cmp > 0)
                     node.right = delete(node.right, key);
              else {
                     if (node.left == null) {
                            size--;
                            return node.right;
                     }
                     if (node.right == null) {
                            size--;
                            return node.left;
                     }
                     Node<E> min = findMin(node.right);
                     node.data = min.data;
                     node.right = delete(node.right, min.data);
              }
              return node;
       }

       private Node<E> findMin(Node<E> node) {
              while (node.left != null)
                     node = node.left;
              return node;
       }

       public void preOrder() {
              preOrderTraverse();
       }

       public void inOrder() {
              inOrderTraverse();
       }

       public void postOrder() {
              postOrderTraverse();
       }
}
