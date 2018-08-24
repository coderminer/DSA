package main

import (
	"fmt"
)

func search(arrs []int, target int) int {
	if len(arrs) > 0 {
		for i := 0; i < len(arrs); i++ {
			if arrs[i] == target {
				return i
			}
		}
	}
	return -1
}

func main() {
	var target int = 85
	arrs := []int{2, 3, 4, 5, 6, 8, 1, 9, 10, 23, 13, 34, 43, 12, 14, 15, 16}
	fmt.Println(search(arrs,target))
}
