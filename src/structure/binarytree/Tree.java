package structure.binarytree;

public class Tree {
    private Node root;
    private int size;

    public Tree() {
        this.root = null;
        this.size = 0;
    }

    public void addNode(int value) {
        if (root == null) {
            Node node = new Node();
            node.setValue(value);
            root = node;
        } else {
            addNode(root, value);
        }
    }

    private void addNode(Node parent, int value) {
        if (value <= parent.getValue()) {
            if(parent.getLeft() == null) {
                Node node = new Node();
                node.setValue(value);
                parent.setLeft(node);
            }else {
                addNode(parent.getLeft(), value);
            }
        } else {
            if(parent.getRight() == null) {
                Node node = new Node();
                node.setValue(value);
                parent.setRight(node);
            }else {
                addNode(parent.getRight(), value);
            }
        }
    }

    public void preOrder(Node node) {
        if(node == null) {
            return;
        }

        System.out.println(node.getValue());
        preOrder(node.getLeft());
        preOrder(node.getRight());
    }

    public void inOrder(Node node) {
        if(node == null) {
            return;
        }

        preOrder(node.getLeft());
        System.out.println(node.getValue());
        preOrder(node.getRight());

    }

    public void postOrder(Node node) {
        if(node == null) {
            return;
        }

        preOrder(node.getLeft());
        preOrder(node.getRight());
        System.out.println(node.getValue());
    }
}
