class Node(object):
    def __init__(self,data):
        self.data = data
        self.left = None
        self.right = None

class BinarySearchTree(object):
    def __init__(self):
        self.root = None
        self.size = 0

    def put(self,data):
        if not self.root:
            self.root = Node(data)
        else:
            self._put(self.root,data)
        self.size += 1

    def _put(self,root,data):
        if data < root.data:
            if not root.left:
                root.left = Node(data)
            else:
                self._put(root.left,data)
        else:
            if not root.right:
                root.right = Node(data)
            else:
                self._put(root.right,data)

    def isEmpty(self):
        return self.root is None

    def min(self):
        if not self.root:
            return None
        else:
            return self._min(self.root)

    def _min(self,root):
        
        # if not root.left:
        #     return root 
        # return self.min(root.left)
        node = root.left
        while node.left:
            node = node.left
        return node 
    
    def max(self):
        if not self.root:
            return None
        else:
            return self._max(self.root)
    def _max(self,root):
        # if not root.right:
        #     return root
        # return self.max(root.right)
        node = root.right
        while node.right:
            node = node.right
        return node

    def find(self,data):
        if not self.root:
            return None
        else:
            return self._find(self.root,data)

    def _find(self,root,data):
        if data == root.data:
            return root
        if data < root.data:
            return self._find(root.left,data)
        else:
            return self._find(root.right,data)

    def findParent(self,data):
        if not self.root:
            return None
        else:
            return self._findParent(self.root,data)

    def _findParent(self,root,data):
        if data == root.data:
            return None 
        if data < root.data:
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
        
        
    def delete(self,root,data):
        nodeToRemove = self.find(data)
        if not nodeToRemove:
            return False
        parent = self.findParent(data)
        if self.size == 1:
            root = None
        elif not nodeToRemove.left and not nodeToRemove.right: # leaf node,has no left and right subtree
            if nodeToRemove.data < parent.data:
                parent.left = None
            else:
                parent.right = None
        elif not nodeToRemove.left and nodeToRemove.right: # has right substree
            if nodeToRemove.data < parent.data:
                parent.left = nodeToRemove.right
            else:
                parent.right = nodeToRemove.right
        elif nodeToRemove.left and not nodeToRemove.right: # has left subtree
            if nodeToRemove.data < parent.data:
                parent.left = nodeToRemove.left
            else:
                parent.right = nodeToRemove.left
        else:                                             # has left and right subtree
            largestValue = nodeToRemove.left
            while largestValue.right:
                largestValue = largestValue.right
            self.delete(root,largestValue.data)
            nodeToRemove.data = largestValue.data
        self.size -= 1
        return True

    def contains(self,data):
        return self._contains(self.root,data)

    def _contains(self,root,data):
        if not root:
            return False
        if data == root.data:
            return True
        elif data < root.data:
            return self._contains(root.left,data)
        else:
            return self._contains(root.right,data)

    def preOrder(self):
        return self._preOrder(self.root)

    def _preOrder(self,root):
        if root:
            print(root.data)
            self._preOrder(root.left)
            self._preOrder(root.right)

    def inOrder(self):
        return self._inOrder(self.root)

    def _inOrder(self,root):
        if root:
            self._inOrder(root.left)
            print(root.data)
            self._inOrder(root.right)

    def postOrder(self):
        return self._postOrder(self.root)

    def _postOrder(self,root):
        if root:
            self._postOrder(root.left)
            self._postOrder(root.right)
            print(root.data)

if __name__ == '__main__':
    tree = BinarySearchTree()
    tree.put(10)
    tree.put(15)
    tree.put(6)
    tree.put(4)
    tree.put(9)
    tree.put(12)
    tree.put(24)
    tree.put(7)
    tree.put(34)
    tree.put(18)
    tree.put(20)

    # tree.delete(tree.root,20)
    # parent = tree.findParent(tree.root,24)
    # print(parent.data)

    tree.delete(tree.root,18)
    tree.postOrder()
    print("\n")
    print(tree.contains(656))