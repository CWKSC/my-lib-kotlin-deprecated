package algorithm.multiplicationsebsequence

object MultiplicationSubsequence {

    fun findLongest(sequence: List<Int>): List<Int> {
        val size = sequence.size
        val dp = IntArray(size)
        val p = IntArray(size)

        dp[0] = 1
        p[0] = -1
        var dpMax = 1
        var indexDpMax = -1
        for (i in 1 until size) {
            val current = sequence[i]
            var maxCount = 1
            var indexMaxCount = -1
            for (j in i - 1 downTo 0) {
                if (current % sequence[j] != 0) continue
                val count = 1 + dp[j]
                if (count > maxCount) {
                    maxCount = count
                    indexMaxCount = j
                }
            }
            p[i] = indexMaxCount
            dp[i] = maxCount
            if (maxCount > dpMax) {
                dpMax = maxCount
                indexDpMax = i
            }
        }

        val result = mutableListOf<Int>()
        var current = indexDpMax
        while (current != -1) {
            result.add(sequence[current])
            current = p[current]
        }
        result.reverse()

        return result
    }

}
