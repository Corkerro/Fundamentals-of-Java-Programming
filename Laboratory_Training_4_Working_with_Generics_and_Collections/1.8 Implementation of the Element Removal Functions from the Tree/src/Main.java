public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        System.out.print("Inorder before removal: ");
        bst.inorder();

        System.out.println("Removing 20");
        bst.remove(20);
        System.out.print("Inorder after removal: ");
        bst.inorder();

        System.out.println("Removing 30");
        bst.remove(30);
        System.out.print("Inorder after removal: ");
        bst.inorder();

        System.out.println("Removing 50");
        bst.remove(50);
        System.out.print("Inorder after removal: ");
        bst.inorder();
    }
}
