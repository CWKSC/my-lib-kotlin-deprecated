package algorithm.dp

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class LCSTest {

    @Test
    fun recursionTopDown() {
        val A = "ABCABCBA"
        val B = "CBABCABCC"
        val LCS = LCS.recursionTopDown(A, B)
        assertEquals("ABCABC", LCS)
    }

    @Test
    fun recursionBottomUp() {
        val A = "ABCABCBA"
        val B = "CBABCABCC"
        val LCS = LCS.recursionBottomUp("", A, B)
        assertEquals("CBACBA", LCS)
    }

    @Test
    fun recursionTopDownIndex() {
        val A = "ABCABCBA"
        val B = "CBABCABCC"
        val LCS = LCS.recursionTopDownIndex(A, B, A.length - 1, B.length - 1)
        assertEquals("ABCABC", LCS)
    }

    @Test
    fun dp(){
        val A = "ABCABCBA"
        val B = "CBABCABCC"
        val dp = LCS.dp(A, B)
        assertEquals(6, dp.last().last())
    }


}