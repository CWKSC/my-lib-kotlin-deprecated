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

        fun search(target: String, pattern: String, failArray: IntArray): IntArray {
            val n = target.length
            val m = pattern.length
            var i = 0
            var j = 0
            val result = mutableListOf<Int>()
            while (n - i >= m - j) {
                if (target[i] == pattern[j]) {
                    i++
                    j++
                    if (j == m) {
                        result.add(i - m)
                        j = 0
                    }
                } else if (j > 0) {
                    j = failArray[j - 1]
                } else {
                    i++
                }
            }
            return result.toIntArray()
        }

        fun search(target: String, pattern: String): IntArray {
            val failArray = getFailureArray(pattern)
            return search(target, pattern, failArray)
        }

    }


}