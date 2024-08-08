package algorithm.dp


sealed class LCS {

    companion object {

        private fun longestOne(A: String, B: String): String {
            return if (A.length >= B.length) A else B
        }

        fun recursionTopDown(A: String, B: String): String {
            if (A.isEmpty() || B.isEmpty()) return ""
            val aLast = A.last()
            val bLast = B.last()
            val subA = A.dropLast(1)
            val subB = B.dropLast(1)
            return if (aLast == bLast) {
                recursionTopDown(subA, subB) + aLast
            } else {
                longestOne(
                    recursionTopDown(subA, B),
                    recursionTopDown(A, subB)
                )
            }
        }

        fun recursionBottomUp(LCS: String, remainA: String, remainB: String): String {
            if (remainA.isEmpty() || remainB.isEmpty()) return LCS
            val aFirst = remainA.first()
            val bFirst = remainB.first()
            val subA = remainA.drop(1)
            val subB = remainB.drop(1)

            return if (aFirst == bFirst) {
                recursionBottomUp(LCS, subA, subB) + aFirst
            } else {
                longestOne(
                    recursionBottomUp(LCS, subA, remainB),
                    recursionBottomUp(LCS, remainA, subB)
                )
            }
        }


        fun recursionTopDownIndex(A: String, B: String, indexA: Int, indexB: Int): String {
            if (indexA < 0 || indexB < 0) return ""
            val a = A[indexA]
            val b = B[indexB]
            return if (a == b) {
                recursionTopDownIndex(A, B, indexA - 1, indexB - 1) + a
            } else {
                longestOne(
                    recursionTopDownIndex(A, B, indexA - 1, indexB),
                    recursionTopDownIndex(A, B, indexA, indexB - 1),
                )
            }
        }

        fun dp(A: String, B: String): Array<IntArray> {
            val aLength = A.length
            val bLength = B.length
            val dp = Array(aLength + 1) { IntArray(bLength + 1) { 0 } }
            val direction = Array(aLength + 1) { CharArray(bLength + 1) { ' ' } }

            for (row in 0 until aLength) {
                for (col in 0 until bLength) {
                    if (A[row] == B[col]) {
                        dp[row + 1][col + 1] = dp[row][col] + 1
                        direction[row + 1][col + 1] = '\\'
                    } else if (dp[row][col + 1] >= dp[row + 1][col]) {
                        dp[row + 1][col + 1] = dp[row][col + 1]
                        direction[row + 1][col + 1] = '^'
                    } else {
                        dp[row + 1][col + 1] = dp[row + 1][col]
                        direction[row + 1][col + 1] = '<'
                    }
                }
            }

            return dp
        }

        fun printDp(dp: Array<IntArray>, direction: Array<CharArray>) {
            val aLength = dp.size
            val bLength = dp[0].size
            for (row in 0..aLength) {
                for (col in 0..bLength) {
                    print("${dp[row][col]}${direction[row][col]} ")
                }
                println()
            }
        }

        fun backtracking(dp: Array<IntArray>, direction: Array<CharArray>, A: String): String {
            val aLength = dp.size
            val bLength = dp[0].size

            var lcs = ""
            var row: Int = aLength
            var col: Int = bLength
            while (direction[row][col] != ' ') {
                when (direction[row][col]) {
                    '\\' -> {
                        lcs += A[row - 1]
                        row -= 1
                        col -= 1
                    }
                    '<' -> col -= 1
                    '^' -> row -= 1
                }
            }
            return lcs
        }


    }


}