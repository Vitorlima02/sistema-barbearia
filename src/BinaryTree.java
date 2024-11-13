public class BinaryTree {
    public Node root;

    public BinaryTree() {
        this.root = null;
    }

    public void insert(Person person) {
        root = insertRecursively(root, person);
    }

    private Node insertRecursively(Node root, Person person) {
        if (root == null) {
            return new Node(person);
        }
        if (person.getId() < root.data.getId()) {
            root.left = insertRecursively(root.left, person);
        } else if (person.getId() > root.data.getId()) {
            root.right = insertRecursively(root.right, person);
        }
        return root;
    }

    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print("Id: " + root.data.getId() + "Nome: " + root.data.getName());
            inOrder(root.right);
        }
    }

    public void preOrder(Node root) {
        if (root != null) {
            System.out.print("Id: " + root.data.getId() + "Nome: " + root.data.getName());
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print("Id: " + root.data.getId() + "Nome: " + root.data.getName());
        }
    }

    public Person search(Node root, int id) {
        if (root == null) {
            return null;
        }
        if (root.data.getId() == id) {
            return root.data;
        }
        return search(root, id);
    }

    public Person searchPerson(int id) {
        return search(root, id);
    }
}
