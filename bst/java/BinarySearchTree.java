/**
 * BinarySearchTree
 */
public class BinarySearchTree {
    public Node root;
    public int size;

    public void put(int data) {
        if (this.root == null) {
            this.root = new Node(data);
        } else {
            this.put(this.root, data);
        }
        this.size++;
    }

    // recursion
    private void put(Node root, int data) {
        Node node = new Node(data);
        if (data < root.data) {
            if (root.left == null) {
                root.left = node;
            } else {
                this.put(root.left, data);
            }
        } else {
            if (root.right == null) {
                root.right = node;
            } else {
                this.put(root.right, data);
            }
        }
    }

    // unrecursion
    public void insert(int data) {
        Node node = new Node(data);
        if (this.root == null) {
            this.root = node;
        } else {
            Node curr = this.root;
            Node parent = null;
            while (curr != null) {
                parent = curr;
                if (data < curr.data) {
                    curr = curr.left;
                } else {
                    curr = curr.right;
                }
            }
            if (data < parent.data) {
                parent.left = node;
            } else {
                parent.right = node;
            }
        }
    }

    public boolean contains(int data) {
        return this.contains(this.root, data);
    }

    // recursion
    private boolean contains(Node root, int data) {
        if (root == null) {
            return false;
        }
        if (data == root.data) {
            return true;
        } else if (data < root.data) {
            return contains(root.left, data);
        } else {
            return contains(root.right, data);
        }
    }

    public boolean contains_unrecurse(int data) {
        if (this.root == null) {
            return false;
        }
        Node node = this.root;
        while (node != null && node.data != data) {
            if (data < node.data) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        if (node != null) {
            return node.data == data;
        }
        return false;
    }

    public Node find(int data) {
        if (this.root == null) {
            return null;
        } else {
            return this.find(this.root, data);
        }
    }

    private Node find(Node node, int data) {
        if (node == null) {
            return null;
        }
        if (data == node.data) {
            return node;
        }
        if (data < node.data) {
            return this.find(node.left, data);
        } else {
            return this.find(node.right, data);
        }
    }

    public Node findParent(int data) {
        if (this.root == null) {
            return null;
        }
        return this.findParent(this.root, data);
    }

    private Node findParent(Node node, int data) {
        if (data == node.data) {
            return null;
        }
        if (data < node.data) {
            if (node.left == null) {
                return null;
            } else if (data == node.left.data) {
                return node;
            } else {
                return this.findParent(node.left, data);
            }
        } else {
            if (node.right == null) {
                return null;
            } else if (data == node.right.data) {
                return node;
            } else {
                return this.findParent(node.right, data);
            }
        }
    }

    public boolean delete(int data) {
        Node nodeToRemove = this.find(data);
        if (nodeToRemove == null) {
            return false;
        }
        Node parent = this.findParent(data);
        if (this.size == 1) {
            this.root = null;
        } else if (nodeToRemove.left == null && nodeToRemove.right == null) {
            if (nodeToRemove.data < parent.data) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if (nodeToRemove.left == null && nodeToRemove.right != null) {
            if (nodeToRemove.data < parent.data) {
                parent.left = nodeToRemove.right;
            } else {
                parent.right = nodeToRemove.right;
            }
        } else if (nodeToRemove.left != null && nodeToRemove.right == null) {
            if (nodeToRemove.data < parent.data) {
                parent.left = nodeToRemove.left;
            } else {
                parent.right = nodeToRemove.left;
            }
        } else {
            Node largestValue = nodeToRemove.left;
            while (largestValue.right != null) {
                largestValue = largestValue.right;
            }
            this.delete(largestValue.data);
            nodeToRemove.data = largestValue.data;
        }
        this.size--;
        return true;

    }

    public Node min() {
        if (this.root == null) {
            return null;
        } else {
            return min(this.root);
        }
    }

    private Node min(Node root) {
        Node node = root.left;
        while (node.left != null) {
            node = node.left;
        }
        return node;
        // recursion
        // if(root.left == null){
        // return root;
        // }
        // return min(root.left);
    }

    public Node max() {
        if (this.root == null) {
            return null;
        } else {
            return this.max(this.root);
        }
    }

    private Node max(Node root) {
        Node node = root.right;
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    public void preOrder() {
        this.preOrder(this.root);
    }

    public void inOrder() {
        this.inOrder(this.root);
    }

    private void inOrder(Node root) {
        if (root != null) {
            this.inOrder(root.left);
            System.out.println(root.data);
            this.inOrder(root.right);
        }
    }

    public void postOrder() {
        this.postOrder(this.root);
    }

    private void postOrder(Node root) {
        if (root != null) {
            this.postOrder(root.left);
            this.postOrder(root.right);
            System.out.println(root.data);
        }
    }

    private void preOrder(Node root) {
        if (root != null) {
            System.out.println(root.data);
            this.preOrder(root.left);
            this.preOrder(root.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(10);
        tree.insert(15);
        tree.insert(6);
        tree.insert(4);
        tree.insert(9);
        tree.insert(12);
        tree.insert(24);
        tree.insert(7);
        tree.insert(34);
        tree.insert(18);
        tree.insert(20);

        // tree.preOrder();
        System.out.println();
        Node r = tree.max();
        if (r != null) {
            System.out.println(r.data);
        } else {
            System.out.println("the result is null");
        }

        System.out.println(tree.delete(10));
        tree.preOrder();
    }
}