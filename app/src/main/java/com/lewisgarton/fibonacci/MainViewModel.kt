package com.lewisgarton.fibonacci

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * ModelView for MainActivity, directs the FibonacciGenerator model
 */
class MainViewModel : ViewModel() {
    private var fibGenerator: FibonacciGenerator = FibonacciGenerator()
    var sequenceOutputStr: MutableLiveData<String> = MutableLiveData()
    var hasGeneratorReset: MutableLiveData<Boolean> = MutableLiveData()

    init {
        sequenceOutputStr.value = formatOutputString()
        hasGeneratorReset.value = false
    }

     /**
     * Requests generator to increment next value and updates output string
     * resets generator if end of sequence reached
     */
    fun nextButtonClicked() {
        fibGenerator.generateNext()

        if(!fibGenerator.hasNext && hasGeneratorReset.value == false) {
            hasGeneratorReset.value = true;
            fibGenerator.reset()
        }

        sequenceOutputStr.value = formatOutputString()
    }

    /**
     * Formats fibonacci numbers into a string for UI
     * example output:
     *      n = n-1 + n-2
     */
    private fun formatOutputString(): String {
        return "${fibGenerator.nextFib} = ${fibGenerator.currentFib} + ${fibGenerator.previousFib}"
    }

}