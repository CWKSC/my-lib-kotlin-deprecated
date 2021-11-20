package algorithm.stringsearch

import algorithm.stringsearch.KMP.Companion.getFailureArray
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class KMPTest {


    @Nested
    inner class GetFailureArrayTest {

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

    }

    @Nested
    inner class SearchTest {

        @Test
        fun search() {
            assertArrayEquals(
                intArrayOf(2, 9),
                KMP.search("abababcabababcc", "ababc")
            )
        }

        @Test
        fun search2() {
            assertArrayEquals(
                intArrayOf(13),
                KMP.search("BBCABCDABABCDABCDABDE", "ABCDABD")
            )
        }

        @Test
        fun search3() {
            assertArrayEquals(
                intArrayOf(0),
                KMP.search("ABC", "ABC")
            )
        }

        @Test
        fun search4() {
            assertArrayEquals(
                intArrayOf(0, 4),
                KMP.search("AABBAABB", "AABB")
            )
        }

    }


}