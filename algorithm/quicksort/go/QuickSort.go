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

func partition(arr []int, left int, right int) int {
	pivot := arr[right]
	i := left - 1
	for j := left; j < right; j++ {
		if arr[j] <= pivot {
			i += 1
			arr[j], arr[i] = arr[i], arr[j]
		}
	}
	arr[i+1], arr[right] = arr[right], arr[i+1]
	return i + 1
}

func quickSort2(arr []int, left int, right int) {
	if left < right {
		p := partition(arr, left, right)
		quickSort2(arr, left, p-1)
		quickSort2(arr, p+1, right)
	}
}

func quickSort3(arr []int, left int, right int) {
	for left < right {
		p := partition(arr, left, right)
		quickSort3(arr, left, p-1)
		left = p + 1
	}
}

func quickSort4(arr []int, left int, right int) {
	for left < right {
		p := partition(arr, left, right)
		if left-p < right-p {
			quickSort4(arr, left, p-1)
			left = p + 1
		} else {
			quickSort4(arr, p+1, right)
			right = p - 1
		}
	}
}

func main() {
	arr := []int{4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4}
	quickSort4(arr, 0, len(arr)-1)
	fmt.Println(arr)
}
