package intervalscheduling

data class WeightedJob(override val start: Double, override val finish: Double, val weight: Double) :
    Interval(start, finish)


fun Array<WeightedJob>.findMaxSumWeightJobsWithoutOverlap(): List<WeightedJob> {
    val jobs = clone()
    jobs.sortBy { it.finish }

    val pArray = jobs.mapIndexed { i, _ -> jobs.p(i) }
    val dp = DoubleArray(jobs.size)

    val backtracking = BooleanArray(jobs.size)
    for (i in 1 until jobs.size) {
        val pickUp = jobs[i].weight + dp[pArray[i]]
        if (pickUp > dp[i - 1]) {
            dp[i] = pickUp
            backtracking[i] = true
        } else {
            dp[i] = dp[i - 1]
            backtracking[i] = false
        }
    }

    val selectedJobs = mutableListOf<Int>()
    var current = dp.size - 1
    while (current != 0) {
        if (backtracking[current]) {
            selectedJobs.add(current)
            current = jobs.p(current)
        } else {
            current--
        }
    }
    selectedJobs.reverse()
    return selectedJobs.map { jobs[it] }
}
