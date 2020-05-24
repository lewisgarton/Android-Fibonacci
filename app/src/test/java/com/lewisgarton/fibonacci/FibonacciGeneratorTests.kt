package com.lewisgarton.fibonacci

import org.junit.Test

import org.junit.Assert.*

/**
 * Tests for the FibonacciGenerator class cover ensuring the sequence is correct and
 * ensures the generator stops before overflowing int
 */
class FibonacciGeneratorTest {

    @Test
    fun isSequenceCorrect() {
        val fibGenerator = FibonacciGenerator()
        val correct: IntArray = intArrayOf(1, 2, 3, 5, 8, 13)
        var result = IntArray(6)

        for(index: Int in 0 until 6) {
            result[index] = fibGenerator.nextFib
            fibGenerator.generateNext()
        }
        assertArrayEquals(correct, result)
    }

    @Test
    fun stopsGeneratingAtMaxInt() {
        val fibGenerator = FibonacciGenerator()

        fibGenerator.currentFib = Int.MAX_VALUE
        fibGenerator.nextFib = 1
        fibGenerator.generateNext()

        assertEquals(fibGenerator.nextFib, fibGenerator.nextFib)
        assertFalse(fibGenerator.hasNext)
    }
}
