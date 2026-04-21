package com.estibenlicona.samsungtvremote.ir

import android.content.Context
import android.hardware.ConsumerIrManager
import android.util.Log

class IrController(context: Context) {

    private val irManager: ConsumerIrManager? =
        context.getSystemService(Context.CONSUMER_IR_SERVICE) as? ConsumerIrManager

    val hasIrEmitter: Boolean
        get() = irManager?.hasIrEmitter() == true

    fun transmitSamsung(hexCommand: Int) {
        if (!hasIrEmitter) return

        val pattern = buildNecPattern(hexCommand)
        try {
            irManager?.transmit(38_000, pattern)
        } catch (exception: Exception) {
            Log.e(TAG, "Error transmitiendo comando IR Samsung", exception)
        }
    }

    private fun buildNecPattern(hexCommand: Int): IntArray {
        val pattern = mutableListOf<Int>()

        // Leader code
        pattern += 9_000
        pattern += 4_500

        // 32 bits, MSB first
        for (bitIndex in 31 downTo 0) {
            pattern += 560
            val bit = (hexCommand ushr bitIndex) and 0x1
            pattern += if (bit == 1) 1_690 else 560
        }

        // Stop bit
        pattern += 560

        return pattern.toIntArray()
    }

    private companion object {
        const val TAG = "IrController"
    }
}
