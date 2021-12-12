package algorithm.intervalscheduling

import algorithm.intervalscheduling.IntervalScheduling.getMaxNumOfCompatibleInterval
import algorithm.intervalscheduling.IntervalScheduling.p
import lib.common.interval.Interval
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested

internal class IntervalSchedulingTest {

    @Nested
    inner class GetMaximumNumberOfJobsTest {

        @Test
        fun normal() {
            val input = listOf(
                Interval(1.0, 2.0),
                Interval(2.0, 3.0),
                Interval(3.0, 4.0),
            )
            val output = input.getMaxNumOfCompatibleInterval()
            assertEquals(input, output)
        }

        @Test
        fun all_overlapping() {
            val input = listOf(
                Interval(1.0, 4.0),
                Interval(2.0, 5.0),
                Interval(3.0, 6.0),
            )
            val output = input.getMaxNumOfCompatibleInterval()
            assertEquals(listOf(Interval(1.0, 4.0)), output)
        }

        @Test
        fun all_same() {
            val input = listOf(
                Interval(1.0, 42.0),
                Interval(1.0, 42.0),
                Interval(1.0, 42.0),
                Interval(1.0, 42.0),
                Interval(1.0, 42.0),
            )
            val output = input.getMaxNumOfCompatibleInterval()
            assertEquals(listOf(Interval(1.0, 42.0)), output)
        }

    }

    @Nested
    inner class PFunctionTest {

        @Test
        fun testcase1() {
            val intervals = listOf(
                Interval(0.0, 3.0),
                Interval(1.0, 4.0),
                Interval(0.0, 5.0),
                Interval(3.0, 6.0),
                Interval(4.0, 7.0),
                Interval(3.0, 9.0),
                Interval(5.0, 10.0),
                Interval(8.0, 10.0),
            )
            val results = intervals.indices.map { intervals.p(it) }
            assertEquals(listOf(0, -1, -1, 0, 1, 0, 2, 4), results)
        }

    }


}