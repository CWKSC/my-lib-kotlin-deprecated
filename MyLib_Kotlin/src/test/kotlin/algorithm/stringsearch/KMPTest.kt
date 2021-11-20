package algorithm.stringsearch

import algorithm.stringsearch.KMP.Companion.getFailureArray
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class KMPTest {

    @Test
    fun getFailureArray() {
        assertArrayEquals(
            intArrayOf(0, 0, 1, 2, 0, 0, 1, 2, 3, 4, 3),
            getFailureArray("ababbbababa")
        )
    }

    @Test
    fun getFailureArray2() {
        assertArrayEquals(
            intArrayOf(0, 0, 1, 2, 0),
            getFailureArray("ababc")
        )
    }

    @Test
    fun search() {
        val target = "abababcabababcc"
        val pattern = "ababc"
        val failArray = getFailureArray(pattern)
        val result = KMP.search(target, "ababc", failArray)
        assertArrayEquals(intArrayOf(2, 9), result)
    }

}