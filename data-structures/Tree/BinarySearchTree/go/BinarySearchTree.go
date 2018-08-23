package main

import (
	"fmt"
)

type TreeNode struct {
	data  int
	left  *TreeNode
	right *TreeNode
}

type BinarySearchTree struct {
	root *TreeNode
}

func (tree *BinarySearchTree) add(data int) {
	if tree.root == nil {
		tree.root = &TreeNode{data: data, left: nil, right: nil}
	} else {
		add(tree.root, data)
	}
}

func add(root *TreeNode, data int) {
	if data < root.data {
		if root.left == nil {
			root.left = &TreeNode{data: data, left: nil, right: nil}
		} else {
			add(root.left, data)
		}
	} else {
		if root.right == nil {
			root.right = &TreeNode{data: data, left: nil, right: nil}
		} else {
			add(root.right, data)
		}
	}
}

func (tree *BinarySearchTree) find(data int) *TreeNode {
	return find(tree.root, data)
}

func find(root *TreeNode, data int) *TreeNode {
	if root == nil {
		return nil
	}
	if root.data == data {
		return root
	} else if data < root.data {
		return find(root.left, data)
	} else {
		return find(root.right, data)
	}

}

func (tree *BinarySearchTree) findParent(data int) *TreeNode {
	return findParent(tree.root, data)
}

func findParent(root *TreeNode, data int) *TreeNode {
	if root == nil {
		return nil
	}
	if data == root.data {
		return nil
	} else if data < root.data {
		if root.left == nil {
			return nil
		} else if data == root.left.data {
			return root
		} else {
			return findParent(root.left, data)
		}
	} else {
		if root.right == nil {
			return nil
		} else if data == root.right.data {
			return root
		} else {
			return findParent(root.right, data)
		}
	}
}

func (tree *BinarySearchTree) remove(data int) bool {
	nodeToRemoved := tree.find(data)
	if nodeToRemoved == nil {
		return false
	}
	parent := tree.findParent(data)
	if tree.root.left == nil && tree.root.right == nil {
		tree.root = nil
		return true
	} else if nodeToRemoved.left == nil && nodeToRemoved.right == nil {
		if nodeToRemoved.data < parent.data {
			parent.left = nil
		} else {
			parent.right = nil
		}
	} else if nodeToRemoved.left == nil && nodeToRemoved.right != nil {
		if nodeToRemoved.data < parent.data {
			parent.left = nodeToRemoved.right
		} else {
			parent.right = nodeToRemoved.right
		}
	} else if nodeToRemoved.left != nil && nodeToRemoved.right == nil {
		if nodeToRemoved.data < parent.data {
			parent.left = nodeToRemoved.left
		} else {
			parent.right = nodeToRemoved.left
		}
	} else {
		largestValue := nodeToRemoved.left
		for largestValue.right != nil {
			largestValue = largestValue.right
		}
		tree.remove(largestValue.data)
		nodeToRemoved.data = largestValue.data
	}
	return true
}

func (tree *BinarySearchTree) preOrder() {
	preOrder(tree.root)
}

func preOrder(root *TreeNode) {
	if root != nil {
		fmt.Println(root.data)
		preOrder(root.left)
		preOrder(root.right)
	}
}

func (tree *BinarySearchTree) inOrder() {
	inOrder(tree.root)
}

func inOrder(root *TreeNode) {
	if root != nil {
		inOrder(root.left)
		fmt.Println(root.data)
		inOrder(root.right)
	}
}

func (tree *BinarySearchTree) postOrder() {
	postOrder(tree.root)
}

func postOrder(root *TreeNode) {
	if root != nil {
		postOrder(root.left)
		postOrder(root.right)
		fmt.Println(root.data)
	}
}

func main() {
	tree := BinarySearchTree{}
	tree.add(10)
	tree.add(12)
	tree.add(2)
	tree.add(4)
	tree.add(1)

	//tree.preOrder()
	fmt.Println(tree.remove(4))
	tree.preOrder()
}
