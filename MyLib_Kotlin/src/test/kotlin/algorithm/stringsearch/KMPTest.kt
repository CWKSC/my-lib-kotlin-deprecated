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

}