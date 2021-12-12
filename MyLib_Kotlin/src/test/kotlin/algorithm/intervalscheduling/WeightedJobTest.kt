package algorithm.intervalscheduling

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class WeightedJobTest {

    @Test
    fun test_findMaxSumWeightJobsWithoutOverlap() {

        val jobs = arrayOf(
            WeightedJob(0.0, 0.0, 0.0),
            WeightedJob(0.0, 3.0, 3.0),
            WeightedJob(1.0, 4.0, 2.0),
            WeightedJob(0.0, 5.0, 4.0),
            WeightedJob(3.0, 6.0, 1.0),
            WeightedJob(4.0, 7.0, 2.0),
            WeightedJob(3.0, 9.0, 5.0),
            WeightedJob(5.0, 10.0, 2.0),
            WeightedJob(8.0, 10.0, 1.0),
        )

        val selectedJobs = jobs.findMaxSumWeightJobsWithoutOverlap()
        val sum = selectedJobs.sumOf { it.weight }
        val size = selectedJobs.size

        assertAll(
            { assertEquals(8.0, sum) },
            { assertEquals(2, size) }
        )
    }

    @Test
    fun test_findMaxSumWeightJobsWithoutOverlap2() {

        val jobs = arrayOf(
            WeightedJob(0.0, 0.0, 0.0),
            WeightedJob(0.0, 5.0, 4.0),
            WeightedJob(6.0, 9.0, 5.0),
            WeightedJob(5.0, 8.0, 6.0),
            WeightedJob(3.0, 6.0, 5.0),
            WeightedJob(6.0, 7.0, 4.0),
            WeightedJob(8.0, 11.0, 12.0),
            WeightedJob(7.0, 10.0, 2.0),
            WeightedJob(9.0, 13.0, 7.0),
        )

        val selectedJobs = jobs.findMaxSumWeightJobsWithoutOverlap()
        val sum = selectedJobs.sumOf { it.weight }
        val size = selectedJobs.size

        assertAll(
            { assertEquals(22.0, sum) },
            { assertEquals(3, size) }
        )
    }

}