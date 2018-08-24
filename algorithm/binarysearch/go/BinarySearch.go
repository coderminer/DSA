package main

import (
	"fmt"
)

func binarySearch(arrs []int, target int) int {
	low := 0
	high := len(arrs) - 1
	for low <= high {
		mid := (low + high) >> 1
		midVal := arrs[mid]
		if midVal < target {
			low = mid + 1
		} else if midVal > target {
			high = mid - 1
		} else {
			return mid
		}
	}
	return -1
}

func main() {
	arrs := []int{0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610}
	target := 155

	fmt.Println(binarySearch(arrs,target))
}
