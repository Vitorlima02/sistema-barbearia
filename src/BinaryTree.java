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

    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print("Id: " + root.user.getId() + "Nome: " + root.user.getName());
            inOrder(root.right);
        }
    }

    public void preOrder(Node root) {
        if (root != null) {
            System.out.print("Id: " + root.user.getId() + "Nome: " + root.user.getName());
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print("Id: " + root.user.getId() + "Nome: " + root.user.getName());
        }
    }
}
