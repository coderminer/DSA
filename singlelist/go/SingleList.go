package main

import (
	"fmt"
)

type Node struct {
	val  interface{}
	next *Node
}

type SingleList struct {
	head *Node
	tail *Node
}

func (l *SingleList) AddFromTail(val interface{}) {
	n := &Node{val: val, next: nil}
	if l.head == nil {
		l.head = n
		l.tail = n
	} else {
		l.tail.next = n
		l.tail = n
	}
}

func (l *SingleList) AddFromHead(val interface{}) {
	n := &Node{val: val, next: nil}
	if l.head == nil {
		l.head = n
		l.tail = n
	} else {
		n.next = l.head
		l.head = n
	}
}

func (l *SingleList) Contains(val interface{}) bool {
	n := l.head
	for n != nil {
		if n.val == val {
			return true
		}
		n = n.next
	}
	return false
}

func (l *SingleList) Remove(val interface{}) bool {
	if l.head == nil {
		return false
	}
	n := l.head
	if n.val == val {
		if l.head == l.tail {
			l.tail = nil
			l.head = nil
		} else {
			l.head = l.head.next
		}
		return true
	}

	for n.next != nil {
		if n.next.val == val {
			if n.next == l.tail {
				l.tail = n
			}
			n.next = n.next.next
			return true
		}
		n = n.next
	}

	return false
}

func (l *SingleList) Display() {
	n := l.head
	for n != nil {
		fmt.Println(n.val)
		n = n.next
	}
}

func main() {
	sl := SingleList{}

	for i := 0; i < 10; i++ {
		sl.AddFromTail(i)
	}
	sl.AddFromHead(34)
	sl.AddFromHead(32)

	sl.Display()
	fmt.Println("")
	fmt.Println(sl.Contains(15))
	sl.Remove(15)
	fmt.Println()
	sl.Display()
}
