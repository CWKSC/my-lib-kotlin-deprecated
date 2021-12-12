package algorithm.stringsearch

import algorithm.stringsearch.KMP.Companion.getFailureArray
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class KMPTest {


    @Nested
    inner class GetFailureArrayTest {

        @Test
        fun ABABBBABABA() {
            assertArrayEquals(
                intArrayOf(0, 0, 1, 2, 0, 0, 1, 2, 3, 4, 3),
                getFailureArray("ABABBBABABA")
            )
        }

        @Test
        fun ABABC() {
            assertArrayEquals(
                intArrayOf(0, 0, 1, 2, 0),
                getFailureArray("ABABC")
            )
        }

    }

    @Nested
    inner class SearchTest {

        @Test
        fun repeat_A() {
            assertArrayEquals(
                intArrayOf(0, 1, 2, 3, 4),
                KMP.search("AAAAA", "A")
            )
        }

        @Test
        fun repeat_ABA() {
            assertArrayEquals(
                intArrayOf(0, 2, 4, 6),
                KMP.search("ABABABABA", "ABA")
            )
        }

        @Test
        fun ABABABCABABABCC_ABABC() {
            assertArrayEquals(
                intArrayOf(2, 9),
                KMP.search("ABABABCABABABCC", "ABABC")
            )
        }

        @Test
        fun BBCABCDABABCDABCDABDE_ABCDABD() {
            assertArrayEquals(
                intArrayOf(13),
                KMP.search("BBCABCDABABCDABCDABDE", "ABCDABD")
            )
        }

        @Test
        fun ABC_ABC() {
            assertArrayEquals(
                intArrayOf(0),
                KMP.search("ABC", "ABC")
            )
        }

        @Test
        fun AABBAABB_AABB() {
            assertArrayEquals(
                intArrayOf(0, 4),
                KMP.search("AABBAABB", "AABB")
            )
        }

    }


}