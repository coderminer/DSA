package main

import (
	"fmt"
)

type Node struct {
	data  int
	left  *Node
	right *Node
}

type BinarySearchTree struct {
	root *Node
	size int
}

func (b *BinarySearchTree) Put(data int) {
	if b.root == nil {
		b.root = &Node{data: data, left: nil, right: nil}
	} else {
		b.put(b.root, data)
	}
	b.size++
}

func (b *BinarySearchTree) put(root *Node, data int) {
	node := &Node{data: data, left: nil, right: nil}
	if data < root.data {
		if root.left == nil {
			root.left = node
		} else {
			b.put(root.left, data)
		}
	} else {
		if root.right == nil {
			root.right = node
		} else {
			b.put(root.right, data)
		}
	}
}

func (b *BinarySearchTree) Delete(data int) bool {
	nodeToRemove := b.Find(data)
	if nodeToRemove == nil {
		return false
	}
	parent := b.FindParent(data)
	if b.size == 1 {
		b.root = nil
	} else if nodeToRemove.left == nil && nodeToRemove.right == nil {
		if nodeToRemove.data < parent.data {
			parent.left = nil
		} else {
			parent.right = nil
		}
	} else if nodeToRemove.left == nil && nodeToRemove.right != nil {
		if nodeToRemove.data < parent.data {
			parent.left = nodeToRemove.right
		} else {
			parent.right = nodeToRemove.right
		}
	} else if nodeToRemove.left != nil && nodeToRemove.right == nil {
		if nodeToRemove.data < parent.data {
			parent.left = nodeToRemove.left
		} else {
			parent.right = nodeToRemove.left
		}
	} else {
		largestValue := nodeToRemove.left
		for largestValue.right != nil {
			largestValue = largestValue.right
		}
		b.Delete(largestValue.data)
		nodeToRemove.data = largestValue.data
	}
	return true
}

func (b *BinarySearchTree) Find(data int) *Node {
	if b.root == nil {
		return nil
	} else {
		return find(b.root, data)
	}
}

func find(root *Node, data int) *Node {
	if data == root.data {
		return root
	}
	if data < root.data {
		return find(root.left, data)
	} else {
		return find(root.right, data)
	}
}

func (b *BinarySearchTree) FindParent(data int) *Node {
	if b.root == nil {
		return nil
	} else {
		return findParent(b.root, data)
	}
}

func findParent(root *Node, data int) *Node {
	if data == root.data {
		return nil
	}
	if data < root.data {
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

func (b *BinarySearchTree) Min() *Node {
	if b.root == nil {
		return nil
	}
	return min(b.root)
}

func min(root *Node) *Node {
	if root.left == nil {
		return root
	}
	return min(root.left)
}

func (b *BinarySearchTree) Max() *Node {
	if b.root == nil {
		return nil
	}
	return max(b.root)
}

func max(root *Node) *Node {
	if root.right == nil {
		return root
	}
	return max(root.right)
}

func (b *BinarySearchTree) PreOrder() {
	b.preOrder(b.root)
}

func (b *BinarySearchTree) preOrder(root *Node) {
	if root != nil {
		fmt.Println(root.data)
		b.preOrder(root.left)
		b.preOrder(root.right)
	}
}

func main() {

	tree := BinarySearchTree{}
	tree.Put(10)
	tree.Put(15)
	tree.Put(6)
	tree.Put(4)
	tree.Put(9)
	tree.Put(12)
	tree.Put(24)
	tree.Put(7)
	tree.Put(34)
	tree.Put(18)
	tree.Put(20)

	//tree.PreOrder()
	fmt.Println()
	r := tree.Delete(24)
	fmt.Println(r)
	tree.PreOrder()
}
