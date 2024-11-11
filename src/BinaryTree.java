public class BinaryTree {
    public Node root;

    public BinaryTree() {
        this.root = null;
    }

    public void insert(User user) {
        root = insertRecursively(root, user);
    }

    private Node insertRecursively(Node root, User user) {
        if (root == null) {
            return new Node(user);
        }
        if (user.getId() < root.user.getId()) {
            root.left = insertRecursively(root.left, user);
        } else if (user.getId() > root.user.getId()) {
            root.right = insertRecursively(root.right, user);
        }
        return root;
    }
}
