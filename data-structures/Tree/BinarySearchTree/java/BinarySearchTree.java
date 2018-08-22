/**
 * BinarySearchTree
 */
public class BinarySearchTree {

    public TreeNode root;

    public void add(int data){
        TreeNode node = new TreeNode(data);
        if(this.root == null){
            this.root = node;
        }else{
            this.insertNode(this.root,data);
        }
    }

    private void insertNode(TreeNode root,int data){
        TreeNode node = new TreeNode(data);
        if(data < root.data){
            if(root.left == null){
                root.left = node;
            }else{
                this.insertNode(root.left,data);
            }
        }else{
            if(root.right == null){
                root.right = node;
            }else{
                this.insertNode(root.right,data);
            }
        }
    }

    public boolean search(int data){
        return this.find(data) != null;
    }

    public TreeNode find(int data){
        return find(this.root,data);
    }

    private TreeNode find(TreeNode root,int data){
        if(root == null)return null;
        if(data == root.data){
            return root;
        }else if(data < root.data){
            return find(root.left,data);
        }else{
            return find(root.right,data);
        }
    }

    public TreeNode findParent(int data){
        return findParent(this.root,data);
    }

    private TreeNode findParent(TreeNode root,int data){
        if(root == null)return null;
        if(root.data == data) return null;
        if(data < root.data){
            if(root.left == null){
                return null;
            }else if(data == root.left.data){
                return root;
            }else{
                return findParent(root.left,data);
            }
        }else{
            if(root.right == null){
                return null;
            }else if(data == root.right.data){
                return root;
            }else{
                return findParent(root.right,data);
            }
        }
    }

    public boolean remove(int data){
        TreeNode nodeToRemoved = find(data);

        if(null == nodeToRemoved)return false;
        
        TreeNode parent = findParent(data);
        if (this.root.left == null && this.root.right == null){
            this.root = null;
        }else if(nodeToRemoved.left == null && nodeToRemoved.right == null){
            if(nodeToRemoved.data < parent.data){
                parent.left = null;
            }else{
                parent.right = null;
            }
        }else if(nodeToRemoved.left == null && nodeToRemoved.right != null){
            if(nodeToRemoved.data < parent.data){
                parent.left = nodeToRemoved.right;
            }else{
                parent.right = nodeToRemoved.right;
            }
        }else if(nodeToRemoved.left != null && nodeToRemoved.right == null){
            if(nodeToRemoved.data < parent.data){
                parent.left = nodeToRemoved.left;
            }else{
                parent.right = nodeToRemoved.left;
            }
        }else{
            
            TreeNode largestValue = nodeToRemoved.left;
            while (largestValue.right != null) {
                largestValue = largestValue.right;
            }
            this.remove(largestValue.data);
            nodeToRemoved.data = largestValue.data;
        }
        return true;
    }

    public void preOrder(){
        preOrder(this.root);
    }

    private void preOrder(TreeNode root){
        if(root != null){
            System.out.println(root.data);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void inOrder(){
        inOrder(this.root);
    }

    private void inOrder(TreeNode root){
        if(root != null){
            inOrder(root.left);
            System.out.println(root.data);
            inOrder(root.right);
        }
    }

    public void postOrder(){
        postOrder(this.root);
    }

    private void postOrder(TreeNode root){
        if(root != null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.data);
        }
    }


    public static void main(String[] args){
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(10);
        tree.add(2);
        tree.add(12);
        tree.add(4);
        tree.add(1);

        System.out.println(tree.root.data+" left: "+tree.root.left.data+" right: "+tree.root.right.data);
        tree.remove(10);
        tree.preOrder();
        
    }
}