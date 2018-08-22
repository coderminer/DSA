class TreeNode(object):
    def __init__(self,data):
        self.data = data
        self.left = None
        self.right = None

class BinarySearchTree(object):
    def __init__(self, *args):
        self.root = None

    def add(self,data):
        if not self.root:
            self.root = TreeNode(data)
        else:
            self._add(self.root,data)

    def _add(self,root,data):
        if data < root.data:
            if not root.left:
                root.left = TreeNode(data)
            else:
                self._add(root.left,data)
        else:
            if not root.right:
                root.right = TreeNode(data)
            else:
                self._add(root.right,data)

    def find(self,data):
        return self._find(self.root,data)


    def _find(self,root,data):
        if not root:
            return None

        if data == root.data:
            return root
        elif data < root.data:
            return self._find(root.left,data)
        else:
            return self._find(root.right,data)
            


    def findParent(self,data):
        return self._findParent(self.root,data)

    def _findParent(self,root,data):
        if not root:
            return None
        if data == root.data:
            return None
        elif data < root.data:
            if not root.left:
                return None
            elif data == root.left.data:
                return root
            else:
                return self._findParent(root.left,data)
        else:
            if not root.right:
                return None
            elif data == root.right.data:
                return root
            else:
                return self._findParent(root.right,data)

    def remove(self,data):
        nodeToRemoved = self.find(data)
        if not nodeToRemoved:
            return False
        parent = self.findParent(data)
        if not self.root.left and not self.root.right:
            self.root = None
            return True
        elif not nodeToRemoved.left and not nodeToRemoved.right:
            if nodeToRemoved.data < parent.data:
                parent.left = None
            else:
                parent.right = None
        elif not nodeToRemoved.left and nodeToRemoved.right:
            if nodeToRemoved.data < parent.data:
                parent.left = nodeToRemoved.right
            else:
                parent.right = nodeToRemoved.right

        elif nodeToRemoved.left and not nodeToRemoved.right:
            if nodeToRemoved.data < parent.data:
                parent.left = nodeToRemoved.left
            else:
                parent.right = nodeToRemoved.right
        else:
            largestValue = nodeToRemoved.left
            while largestValue.right:
                largestValue = largestValue.right
            self.remove(largestValue.data)
            nodeToRemoved.data = largestValue.data
        return True

    def preOrder(self):
        self._preOrder(self.root)

    def _preOrder(self,root):
        if root:
            print(root.data)
            self._preOrder(root.left)
            self._preOrder(root.right)
    
    def inOrder(self):
        self._inOrder(self.root)

    def _inOrder(self,root):
        if root:
            self._inOrder(root.left)
            print(root.data)
            self._inOrder(root.right)

    def postOrder(self):
        self._postOrder(self.root)

    def _postOrder(self,root):
        if root:
            self._postOrder(root.left)
            self._postOrder(root.right)
            print(root.data)
        

if __name__ == '__main__':
    tree = BinarySearchTree()

    tree.add(10)
    tree.add(12)
    tree.add(2)
    tree.add(4)
    tree.add(1)

    print(tree.remove(15))
    tree.preOrder()
