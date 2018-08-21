def bubble_sort():
    l = [3,1,23,45,4,5,13,25,56,24]
    print(l)
    for i in range(0,len(l)):
        for j in range(0,len(l)):
            if l[i] < l[j]:
                l[i],l[j] = l[j],l[i]


    return l

if __name__ == "__main__":
    l = bubble_sort()
    print(l)