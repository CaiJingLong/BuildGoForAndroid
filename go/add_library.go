package main

import "C"

//export add
func add(x, y int) int {
	return x + y
}

//export remove_int
func remove_int(x, y int) int {
	return x - y
}

func main() {
}
