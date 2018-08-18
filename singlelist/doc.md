### 单向链表

一般情况下在单向链表中插入数据，指的就是在链表的结尾处插入新数据，插入时要考虑两种情况  

1. 当head是null时，就是链表是空时，
2. 链表不为空时，在尾部追加一个节点，并把tail指向这个节点

```
Add(value)
    n = node(value)
    if head == null
        head = n
        tail = n
    else
        tail.next = n
        tail = n
```

#### 查找

在链表中查找一个元素，就是需要遍历整个链表，并同时比较当前值和查询值是否一致，如果一致就返回  

```
Contains(value)
    n = head
    while n != null and n.value != value
        n = n.next
    if n == null
        return false
    return true
```

#### 删除

删除一个元素时，需要考虑以下几种情况  

1. 当链表为空时
2. 当链表只有一个节点，而这个节点就是要删除的节点时
3. 删除的是头节点时
4. 删除的是尾节点时
5. 删除的是中间节点时
6. 当删除的节点不存在时

```
Remove(value)
    if head == null  //case 1
        return false
    n = head
    if n.value == value
        if head == tail // case 2
            head = null
            tail = null
        else // case 3
            head = head.next
        return true
    while n.next != null
        if n.next.value == value
            if n.next == tail
                tail = n
            n.next = n.next.next
            return true
        n = n.next
    return false

```

#### 遍历

```
Traverse()
    n = head
    while n != null:
        yield n.value
        n = n.next
```

#### 逆向遍历

```
Reverse()
    if tail != null
        cur = tail
        while cur != head
            prev = head
            whiel prev.next != cur
                prve = prev.next
            yield cur.value
            cur = prev
        yield cur.value
```