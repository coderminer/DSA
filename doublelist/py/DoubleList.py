class Node(object):
    def __init__(self,val):
        self.val = val
        self.prev = None
        self.next = None 


class DoubleList(object):
    def __init__(self):
        self.head = None
        self.tail = None 


    def addFromTail(self,val):
        n = Node(val)
        if not self.head:
            self.head = n
            self.tail = n 
        else:
            n.prev = self.tail
            self.tail.next = n
            self.tail = n


    def addFromHead(self,val):
        n = Node(val)
        if not self.head:
            self.head = n
            self.tail = n 
        else:
            n.next = self.head
            self.head.prev = n
            self.head = n

    def traverse(self):
        n = self.head
        while n:
            print(n.val)
            n = n.next

    def reverse(self):
        n = self.tail
        while n :
            print(n.val)
            n = n.prev

    def contains(self,val):
        n = self.head
        while n:
            if n.val == val:
                return True
            n = n.next
        return False 


    def remove(self,val):
        if not self.head:
            return False
        if self.head.val == val:
            if self.head == self.tail:
                self.head = None
                self.tail = None 
            else:
                self.head = self.head.next
                self.head.prev = None 
            return True
        n = self.head.next
        while n:
            if n.val == val:
                if n == self.tail:
                    self.tail = self.tail.prev
                    self.tail.next = None
                else:
                    n.prev.next = n.next
                    n.next.prev = n.prev
            
                return True
            n = n.next
        return False

if __name__ == '__main__':
    dl = DoubleList()
    for i in range(0,10):
        dl.addFromTail(i)

    dl.addFromHead(32)
    dl.traverse()
    print("\n")
    #dl.reverse()
    print(dl.contains(14))
    dl.remove(32)
    dl.traverse()