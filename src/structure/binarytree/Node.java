package structure.binarytree;

public class Node {
    private int value;
    private Node left;
    private Node right;

    public void setValue(int value) {
        this.value = value;
    }

    public void setLeft(Node node) {
        this.left = node;
    }

    public void setRight(Node node) {
        this.right = node;
    }

    public int getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }
}
