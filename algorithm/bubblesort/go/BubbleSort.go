package main

import (
	"fmt"
)

func main() {
	var arrs = [...]int{3, 1, 23, 45, 4, 5, 13, 25, 56, 24}

	var len int = len(arrs)
	for i := 0; i < len; i++ {
		for j := 0; j < len; j++ {
			if arrs[i] < arrs[j] {
				arrs[i], arrs[j] = arrs[j], arrs[i]
			}
		}
	}

	fmt.Println(arrs)
}
