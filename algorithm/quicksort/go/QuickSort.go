package main

import "fmt"

func QuickSort(arr []int, left int, right int) {
	var i, j int
	if left > right {
		return
	}
	i = left
	j = right
	tmp := arr[left]

	for i != j {
		for arr[j] >= tmp && i < j {
			j--
		}
		for arr[i] <= tmp && i < j {
			i++
		}
		if i < j {
			arr[i], arr[j] = arr[j], arr[i]
		}
	}

	arr[left], arr[i] = arr[i], arr[left]

	fmt.Println(arr)
	QuickSort(arr, left, i-1)
	QuickSort(arr, i+1, right)
}

func main() {
	arr := []int{4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4}
	QuickSort(arr, 0, len(arr)-1)
}
