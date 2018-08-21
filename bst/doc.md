### 二叉树

#### 插入

```
Insert(value)
    if root == null
        root = node(value)
    else
        InsertNode(root,value)


InsertNode(current,value)
    if value < current.Left 
        if current.Left == null
            current.Left = node(v)
        else
            InsertNode(current.Left,value)
    else
        if current.Right == null
            current.Right = node(value)
        else
            InsertNode(current.Right,value)
```

#### 查询 

```
Contains(root,value)
    if root == null
        return false
    if root.value == value
        return true
    else if value < root.value
        return Contains(root.Left,value)
    else
        return Contains(root.Right,value)
```

#### 删除

1. 删除中的节点是叶子节点(叶子节点：没有左右子树节点)
2. 删除的节点有右子树，而没有左子树
3. 删除的节点有左子树，而没有右子树
4. 删除的节点有左右子树

```

Remove(root,value)
    nodeToRemove = FindNode(root,value)
    if nodeToRemove == null
        return false
    parent = FindParentNode(root,value)
    if count == 1
        root = null
    else if nodeToRemove.Left == null and nodeToRemove.Right == null // case 1
        if nodeToRemove.value < parent.value
            parent.Left = null
        else
            parent.Right = null
    else if nodeToRemove.Left == null and nodeToRemove.Right != null //case 2
        if nodeToRemove.value < parent.value
            parent.Left = nodeToRemove.Right
        else
            parent.Right = nodeToRemove.Right
    else if nodeToRemove.Left != null and nodeToRemove.Right == null //case 3
        if nodeToRemove.value < parent.value
            parent.Left = nodeToRemove.Left
        else 
            parent.Right = nodeToRemove.Left
    else
        largestValue = nodeToRemove.Left
        while largestValue.Right != null
            largestValue = largestValue.Right
        FindParentNode(largestValue.value).Right = null
        nodeToRemove.value = largestValue.value




FindNode(root,value)
    if root == null
        return null
    if root.value == value
        return root
    else if value < root.value
        return FindNode(root.Left,value)
    else
        return FindNode(root.Right,value)


FindParent(root,value)
    if root == null
        return null
    if value == root.value
        return null
    if value < root.value:
        if root.Left == null
            return null
        else if root.Left.value == value
            return root
        else
            return FindParentNode(root.Left,value)
    else
        if root.Right == null
            return null
        else if root.Right.value == value
            return root
        else
            return FindParentNode(root.Right,value)

```