class Node(object):
    def __init__(self, data):
        self.data = data
        self.next = None

class LinkedList(object):
    def __init__(self):
        self.head = None

    def prepend(self,data):
        node = Node(data)
        if self.head:
            node.next = self.head
        self.head = node

    def append(self,data):
        node = Node(data)
        if not self.head:
            self.head = node
            return
        last = self.head
        while last.next:
            last = last.next
        last.next = node
        
    def search(self,data):
        node = self.head
        while node:
            if node.data == data:
                return True;
            node = node.next
        return False

    def remove(self,data):
        if not self.head:
            return False
        if self.head.data == data:
            self.head = self.head.next
        node = self.head
        while node.next:
            if node.next.data == data:
                node.next = node.next.next
                return True
            node = node.next
        return False

    def first(self):
        return self.head

    def last(self):
        if not self.head:
            return None
        node = self.head
        while node.next:
            node = node.next
        return node

    def size(self):
        count = 0
        node = self.head
        while node:
            count += 1
        return count
        
    def display(self):
        node = self.head
        while node:
            print(node.data)
            node = node.next

    def toArray(self):
        node = self.head
        l = []
        while node:
            l.append(node.data)
            node = node.next
        print(l)

    def reverse(self):
        cur = self.last()
        while cur != self.head:
            prev = self.head
            while prev.next != cur:
                prev = prev.next
            print(cur.data)
            cur = prev
        print(cur.data)

if __name__=='__main__':
    list = LinkedList()
    list.append(2)
    list.append(4)
    list.append(6)
    list.append(7)
    list.append(9)
    list.append(10)

    #list.display()
    #print(list.first().data,list.last().data)
    #list.toArray()
    list.remove(9)
    list.display()
    print("\n")
    list.reverse()