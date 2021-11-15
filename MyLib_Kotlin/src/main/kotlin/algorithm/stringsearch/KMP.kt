package algorithm.stringsearch

sealed class KMP {

    companion object {
        fun getFailureArray(pattern: String): IntArray {
            val n = pattern.length
            val failure = IntArray(n)
            var j = 0
            for (i in 1 until n) {
                while (j > 0 && pattern[j] != pattern[i]) {
                    j = failure[j - 1]
                }
                if (pattern[i] == pattern[j]) j++
                failure[i] = j
            }
            return failure
        }
    }


}