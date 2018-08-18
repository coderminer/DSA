class Node(object):
    def __init__(self,val,next):
        self.val = val
        self.next = next
    

class SingleList(object):
    def __init__(self, *args):
        self.head = None
        self.tail = None 


    def add(self,val):
        n = Node(val,None)
        if not self.head:
            self.head = n
            self.tail = n
        else:
            self.tail.next = n
            self.tail = n


    def contails(self,val):
        n = self.head
        while n :
            if n.val == val:
                return True
            n = n.next
        return False

    def remove(self,val):
        if not self.head:
            return False
        n = self.head
        if n.val == val:
            if self.head == self.tail:
                self.head = None
                self.tail = None
            else:
                self.head = self.head.next
            return True
        while n.next:
            if n.next.val == val:
                if n.next == self.tail:
                    self.tail = n
                n.next = n.next.next
                return True
            n = n.next

        return False


    def reverse(self):
        if self.tail:
            cur = self.tail
            while cur != self.head:
                prev = self.head
                while prev.next != cur:
                    prev = prev.next
                print(cur.val)
                cur = prev 
            print(cur.val)

    def display(self):
        n = self.head
        while n:
            print(n.val)
            n = n.next


if __name__ == '__main__':
    sl = SingleList()

    sl.add(3)
    sl.add(5)
    sl.add(8)
    sl.add(18)
    sl.display()
    print("\n")
    sl.reverse()