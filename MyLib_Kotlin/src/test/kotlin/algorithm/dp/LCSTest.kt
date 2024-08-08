package algorithm.dp

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class LCSTest {

    @Test
    fun recursionTopDown() {
        val a = "ABCABCBA"
        val b = "CBABCABCC"
        val lcs = LCS.recursionTopDown(a, b)
        assertEquals("ABCABC", lcs)
    }

    @Test
    fun recursionBottomUp() {
        val a = "ABCABCBA"
        val b = "CBABCABCC"
        val lcs = LCS.recursionBottomUp("", a, b)
        assertEquals("CBACBA", lcs)
    }

    @Test
    fun recursionTopDownIndex() {
        val a = "ABCABCBA"
        val b = "CBABCABCC"
        val lcs = LCS.recursionTopDownIndex(a, b, a.length - 1, b.length - 1)
        assertEquals("ABCABC", lcs)
    }

    @Test
    fun dp() {
        val a = "ABCABCBA"
        val b = "CBABCABCC"
        val dp = LCS.dp(a, b)
        assertEquals(6, dp.last().last())
    }


}