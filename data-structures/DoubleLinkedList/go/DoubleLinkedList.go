package main

import (
	"fmt"
)

type Node struct {
	data interface{}
	prev *Node
	next *Node
}

type DoubleLinkedList struct {
	head *Node
	tail *Node
}

func (list *DoubleLinkedList) prepend(data interface{}) {
	node := &Node{data: data, prev: nil, next: nil}
	if list.head == nil {
		list.head = node
		list.tail = node
	} else {
		node.next = list.head
		list.head.prev = node
		list.head = node
	}
}

func (list *DoubleLinkedList) append(data interface{}) {
	node := &Node{data: data, prev: nil, next: nil}
	if list.head == nil {
		list.head = node
		list.tail = node
	} else {
		list.tail.next = node
		node.prev = list.tail
		list.tail = node
	}
}

func (list *DoubleLinkedList) search(data interface{}) bool {
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

func (list *DoubleLinkedList) remove(data interface{}) bool {
	if list.head == nil {
		return false
	}
	if list.head.data == data {
		if list.head == list.tail {
			list.head = nil
			list.tail = nil
		} else {
			list.head = list.head.next
			list.head.prev = nil
		}
		return true
	}
	node := list.head.next
	for node != nil {
		if node.data == data {
			if node == list.tail {
				list.tail = list.tail.prev
				list.tail.next = nil
			} else {
				node.prev.next = node.next
				node.next.prev = node.prev
			}

			return true
		}
		node = node.next
	}
	return false
}

func (list *DoubleLinkedList) size() int {
	node := list.head
	count := 0
	for node != nil {
		count++
		node = node.next
	}
	return count
}

func (list *DoubleLinkedList) traverse() {
	node := list.head
	for node != nil {
		fmt.Println(node.data)
		node = node.next
	}
}

func (list *DoubleLinkedList) reverse() {
	node := list.tail
	for node != nil {
		fmt.Println(node.data)
		node = node.prev
	}
}

func main() {
	list := DoubleLinkedList{}
	list.append(2)
	list.append(4)
	list.append(6)
	list.append(7)
	list.append(9)
	list.append(10)

	//list.traverse()
	fmt.Println(list.remove(4))
	list.traverse()
}
