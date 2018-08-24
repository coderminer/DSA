def search(arr,target):
    for i in range(len(arr)):
        if arr[i] == target:
            return i
    return -1

if __name__ == '__main__':
    target = 4;
    arrs = [2,3,4,5,6,8,1,9,10,23,13,34,43,12,14,15,16];
    print(search(arrs,target))