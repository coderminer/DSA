def binarySearch(arrs,target):
    low = 0
    high = len(arrs) - 1
    while low <= high:
        mid = (low + high) >> 1
        midval = arrs[mid]
        if midval < target:
            low = mid + 1
        elif midval > target:
            high = mid - 1
        else:
            return mid
        
    return -1

if __name__=='__main__':
    arrs = [0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610]
    target = 155
    print(binarySearch(arrs,target))