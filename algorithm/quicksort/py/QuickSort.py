class QuickSort(object):
    def __init__(self):
        self.n = 0

    def quickSort(self, arr, left, right):
        if left > right:
            return
        i = left
        j = right
        tmp = arr[left]

        while i != j:
            while arr[j] >= tmp and i < j:
                j -= 1
            while arr[i] <= tmp and i < j:
                i += 1
            if(i < j):
                arr[i], arr[j] = arr[j], arr[i]

        arr[left], arr[i] = arr[i], arr[left]
        print(arr)
        # print("\n")
        self.quickSort(arr, left, i - 1)
        self.quickSort(arr, i + 1, right)

    def partition(self, arr, left, right):
        pivot = arr[right]
        i = left - 1
        for j in range(left, right):
            if arr[j] < pivot:
                i += 1
                arr[j], arr[i] = arr[i], arr[j]
        arr[i + 1], arr[right] = arr[right], arr[i + 1]
        return i + 1

    def quickSort2(self, arr, left, right):
        if left < right:
            p = self.partition(arr, left, right)
            self.quickSort2(arr, left, p - 1)
            self.quickSort2(arr, p + 1, right)

    def quickSort3(self,arr,left,right):
        while left < right:
            p = self.partition(arr,left,right)
            self.quickSort3(arr,left,p - 1)
            left = p + 1

    def quickSort4(self,arr,left,right):
        while left < right:
            p = self.partition(arr,left,right)
            if p - left < right - p:
                self.quickSort4(arr,left,p - 1)
                left = p + 1
            else:
                self.quickSort4(arr,p + 1,right)
                right = p - 1



if __name__ == '__main__':
    qs = QuickSort()
    arr = [4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4]
    qs.quickSort4(arr, 0, len(arr) - 1)
    print(arr)