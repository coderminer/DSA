class Node(object):
    def __init__(self,data):
        self.data = data
        self.prev = None
        self.next = None

class DoubleLinkedList(object):
    def __init__(self):
        self.head = None
        self.tail = None

    def prepend(self,data):
        node = Node(data)
        if not self.head:
            self.head = node
            self.tail = node
        else:
            node.next = self.head
            self.head.prev = node
            self.head = node

    def append(self,data):
        node = Node(data)
        if not self.head:
            self.head = node
            self.tail = node
        else:
            self.tail.next = node
            node.prev = self.tail
            self.tail = node
    
    def search(self,data):
        if not self.head:
            return False
        node = self.head
        while node:
            if node.data == data:
                return True
            node = node.next
        return False
        
    def remove(self,data):
        if not self.head:
            return False
        if self.head.data == data:
            if self.head == self.tail:
                self.head = None
                self.tail = None
            else:
                self.head = self.head.next
                self.head.prev = None
            return True

        node = self.head.next
        while node:
            if node.data == data:
                if node == self.tail:
                    self.tail = self.tail.prev
                    self.tail.next = None
                else:
                    node.prev.next = node.next
                    node.next.prev = node.prev
                return True
            node = node.next
        return False
    
    def traverse(self):
        node = self.head 
        while node:
            print(node.data)
            node = node.next


    def reverse(self):
        node = self.tail
        while node:
            print(node.data)
            node = node.prev

    def size(self):
        node = self.head
        count = 0
        while node:
            count +=1
            node = node.next
        return count

if __name__ == '__main__':
    list = DoubleLinkedList()
    list.append(2)
    list.append(4)
    list.append(6)
    list.append(7)
    list.append(9)
    list.append(10)

    print(list.remove(9))
    list.traverse()
    