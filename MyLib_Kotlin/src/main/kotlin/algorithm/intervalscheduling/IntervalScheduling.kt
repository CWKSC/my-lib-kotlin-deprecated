package algorithm.intervalscheduling

import lib.common.interval.Interval

object IntervalScheduling {

    fun List<Interval>.getMaxNumOfCompatibleInterval(): MutableList<Interval> {
        sortedBy { it.finish }
        val first = first()
        val result = mutableListOf(first)
        var currentEnd = first.finish
        for (i in 1 until this.size) {
            val job = this[i]
            if (job.start < currentEnd) continue
            result.add(job)
            currentEnd = job.finish
        }
        return result
    }

    fun List<Interval>.p(index: Int): Int {
        if (index == 0) return 0
        val start = this[index].start
        
        for (i in (index - 1) downTo 0) {
            if (this[i].finish > start) continue
            return i
        }
        return -1
    }


}