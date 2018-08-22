package main

import (
	"fmt"
)

type Node struct {
	data interface{}
	next *Node
}

type LinkedList struct {
	head *Node
}

func (list *LinkedList) prepend(data interface{}) {
	node := &Node{data: data, next: nil}
	if list.head != nil {
		node.next = list.head
	}
	list.head = node
}

func (list *LinkedList) append(data interface{}) {
	node := &Node{data: data, next: nil}
	if list.head == nil {
		list.head = node
		return
	}
	cur := list.head
	for cur.next != nil {
		cur = cur.next
	}
	cur.next = node
}

func (list *LinkedList) search(data interface{}) bool {
	if list.head == nil {
		return false
	}
	node := list.head
	for node != nil {
		if node.data == data {
			return true
		}
		node = node.next
	}
	return false
}

func (list *LinkedList) remove(data interface{}) bool {
	if list.head == nil {
		return false
	}
	if list.head.data == data {
		list.head = list.head.next
		return true
	}
	node := list.head
	for node.next != nil {
		if node.next.data == data {
			node.next = node.next.next
			return true
		}
		node = node.next
	}
	return false
}

func (list *LinkedList) size() int {
	count := 0
	node := list.head
	for node != nil {
		node = node.next
		count++
	}
	return count
}

func (list *LinkedList) first() *Node {
	return list.head
}

func (list *LinkedList) last() *Node {
	node := list.head
	for node.next != nil {
		node = node.next
	}
	return node
}

func (list *LinkedList) display() {
	node := list.head
	for node != nil {
		fmt.Println(node.data)
		node = node.next
	}
}

func (list *LinkedList) reverse() {
	cur := list.last()
	for cur != list.head {
		prev := list.head
		for prev.next != cur {
			prev = prev.next
		}
		fmt.Println(cur.data)
		cur = prev
	}
	fmt.Println(cur.data)
}

func main() {
	list := LinkedList{}
	list.append(2)
	list.append(4)
	list.append(6)
	list.append(7)
	list.append(9)
	list.append(10)

	//list.display()
	fmt.Println(list.first(), list.last(), list.size(), list.search(19), list.remove(14))
	fmt.Println()
	list.reverse()
	//list.display()
}
