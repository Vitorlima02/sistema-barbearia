public class Node {
    User user;
    Node left, right;

    public Node(User user) {
        this.user = user;
        left = right = null;
    }
}
