package algorithm.intervalscheduling.intervalpartitioning

import lib.common.interval.Interval

object IntervalPartitioning {

    fun List<Interval>.getMinNumOfPartitioning(): List<List<Interval>> {
        sortedBy { it.start }
        val partitions = mutableListOf<MutableList<Interval>>()
        forEach {
            var indexInsertPartition = -1
            for (i in 0 until partitions.size) {
                val last = partitions[i].last()
                if (last.finish <= it.start) {
                    indexInsertPartition = i
                    break
                }
            }
            if (indexInsertPartition != -1) {
                partitions[indexInsertPartition].add(it)
            } else {
                partitions.add(mutableListOf(it))
            }
        }
        return partitions
    }

}