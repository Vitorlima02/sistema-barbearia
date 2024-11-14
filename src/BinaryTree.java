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
        if (person.getName().compareTo(root.data.getName()) < 0) {
            root.left = insertRecursively(root.left, person);
        } else if (person.getName().compareTo(root.data.getName()) > 0) {
            root.right = insertRecursively(root.right, person);
        }
        return root;
    }

    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print("Id: " + root.data.getId() + "\nNome: " + root.data.getName());
            inOrder(root.right);
        }
    }

    public void preOrder(Node root) {
        if (root != null) {
            System.out.print("Id: " + root.data.getId() + "\nNome: " + root.data.getName());
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

    public void printTree() {
        System.out.println("Exibindo arvore em ordem: ");
        inOrder(root);
//        System.out.println("Exibindo em pos-ordem");
//        postOrder(root);
//        System.out.println("Exibindo em pre-ordem");
//        preOrder(root);
    }
}
