public class BinarySearchTree<T extends Comparable<T>> {

    private static class Node<T> {
        T key;
        Node<T> left, right;

        Node(T key) {
            this.key = key;
        }
    }

    private Node<T> root;

    public void insert(T key) {
        root = insertRec(root, key);
    }

    private Node<T> insertRec(Node<T> node, T key) {
        if (node == null) return new Node<>(key);

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = insertRec(node.left, key);
        } else if (cmp > 0) {
            node.right = insertRec(node.right, key);
        }
        return node;
    }

    public void inorder() {
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(Node<T> node) {
        if (node != null) {
            inorderRec(node.left);
            System.out.print(node.key + " ");
            inorderRec(node.right);
        }
    }

    public void remove(T key) {
        root = removeRec(root, key);
    }

    private Node<T> removeRec(Node<T> node, T key) {
        if (node == null) return null;

        int cmp = key.compareTo(node.key);

        if (cmp < 0) {
            node.left = removeRec(node.left, key);
        } else if (cmp > 0) {
            node.right = removeRec(node.right, key);
        } else {
            if (node.left == null && node.right == null) {
                return null;
            }

            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            Node<T> successor = findMin(node.right);
            node.key = successor.key;
            node.right = removeRec(node.right, successor.key);
        }
        return node;
    }

    private Node<T> findMin(Node<T> node) {
        while (node.left != null)
            node = node.left;
        return node;
    }
}
