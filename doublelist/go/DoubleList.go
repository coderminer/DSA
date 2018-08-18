package main

import (
	"fmt"
)

type Node struct {
	val  interface{}
	prev *Node
	next *Node
}

type DoubleList struct {
	head *Node
	tail *Node
}

func (d *DoubleList) AddFromTail(val interface{}) {
	n := &Node{val: val, prev: nil, next: nil}
	if d.head == nil {
		d.head = n
		d.tail = n
	} else {
		d.tail.next = n
		n.prev = d.tail
		d.tail = n
	}
}

func (d *DoubleList) AddFromHead(val interface{}) {
	n := &Node{val: val, prev: nil, next: nil}
	if d.head == nil {
		d.head = n
		d.tail = n
	} else {
		d.head.prev = n
		n.next = d.head
		d.head = n
	}
}

func (d *DoubleList) Traverse() {
	n := d.head
	for n != nil {
		fmt.Println(n.val)
		n = n.next
	}
}

func (d *DoubleList) Reverse() {
	n := d.tail
	for n != nil {
		fmt.Println(n.val)
		n = n.prev
	}
}

func (d *DoubleList) Contains(val interface{}) bool {
	n := d.head
	for n != nil {
		if n.val == val {
			return true
		}
		n = n.next
	}

	return false
}

func (d *DoubleList) Remove(val interface{}) bool {
	if d.head == nil {
		return false

	}

	if d.head.val == val {
		if d.head == d.tail {
			d.head = nil
			d.tail = nil
		} else {
			d.head = d.head.next
			d.head.prev = nil
		}

		return true
	}

	n := d.head.next
	for n != nil {
		if n.val == val {
			if n == d.tail {
				d.tail = d.tail.prev
				d.tail.next = nil
			} else {
				n.prev.next = n.next
				n.next.prev = n.prev
			}
			return true
		}
		n = n.next
	}
	return false
}

func main() {
	dl := DoubleList{}
	for i := 0; i < 10; i++ {
		dl.AddFromTail(i)
	}
	dl.AddFromHead(32)
	dl.AddFromHead(56)
	dl.Traverse()
	fmt.Println()
	
	fmt.Println(dl.Remove(32))
	dl.Reverse()
}
