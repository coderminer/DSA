### 双向链表

#### 在尾部追加

```
AddFromTail(value)
    n = node(value)
    if head == null
        head = n
        tail = n
    else
        n.prev = tail
        tail.next = n
        tail = n
```

#### 在头部追加

```
AddFromHead(value)
    n = node(value)
    if head == null
        head = n
        tail = n
    else
        n.next = head
        head.prev = n
        head = n
```

#### 查找

```
Contains(value)
    n = head
    while n!= null
        if n.value == value
            return true
        n = n.next

Contains(value)
    n = tail
    while n!= null:
        if n.value == value
            n = n.prev
        n = n.prev
```

#### 遍历

```
Traverse()
    n = head
    while n != null
        yield n.value
        n = n.next
```

#### 逆向遍历

```
Reverse()
    n = tail
    while n!= null
        yield n.value
    n = n.prev
```


#### 删除

```
Remove(value)
    if head == null
        return false
    
    if head.value == value
        if head == tail
            head = null
            tail = null
        else
            head = head.next
            head.prev = null
        return true
    n = head.next
    while n != null
        if n.value == value
            if n == tail
                tail = tail.prev
                tail.next = null
            else
                n.prev.next = n.next
                n.next.prev = n.prev
            return true
        n = n.next
    return false
```