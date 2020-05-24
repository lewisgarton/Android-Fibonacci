package com.lewisgarton.fibonacci

/**
 * Generates fibonacci numbers keeping track of fibonacci number n, n-1, and n-2
 *
 */
class FibonacciGenerator {
    // n = nextFib, n-1 = currentFib, n-2 = previousFib
    var previousFib: Int = 0
    var currentFib: Int = 1
    var nextFib: Int = 1
    // False when fibonacci number > Int.MAX_VALUE
    var hasNext: Boolean = true

    /**
     * Increments the fibonacci sequence
     * example:
     * { 1 = 1 + 0 } --> { 2 = 1 + 1 }
     */
    fun generateNext() {
        // Check if next fibonacci number for int overflow
        if(currentFib.toLong() + nextFib.toLong() > Int.MAX_VALUE) {
            hasNext = false
        } else {
            previousFib = currentFib
            currentFib = nextFib
            nextFib = previousFib + currentFib
        }
    }

    /**
     * Resets members to initial values
     */
    fun reset() {
        previousFib = 0
        currentFib = 1
        nextFib = 1
        hasNext = true
    }
}