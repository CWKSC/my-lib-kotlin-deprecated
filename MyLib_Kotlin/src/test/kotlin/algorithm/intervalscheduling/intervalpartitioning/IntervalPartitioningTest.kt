package algorithm.intervalscheduling.intervalpartitioning

import algorithm.intervalscheduling.intervalpartitioning.IntervalPartitioning.getMinNumOfPartitioning
import lib.common.interval.Interval
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class IntervalPartitioningTest {


    @Nested
    inner class GetMinNumOfPartitioningTest {

        @Test
        fun same_6_should_6_Partition() {
            val input = listOf(
                Interval(1.0, 42.0),
                Interval(1.0, 42.0),
                Interval(1.0, 42.0),
                Interval(1.0, 42.0),
                Interval(1.0, 42.0),
                Interval(1.0, 42.0),
            )
            val output = input.getMinNumOfPartitioning()
            assertEquals(6, output.size)
        }

        // Reference: https://www.youtube.com/watch?v=i_G8hZYcKnI
        @Test
        fun testcase1() {
            val item1 = Interval(10.0, 11.0)
            val item2 = Interval(10.0, 12.0)
            val item3 = Interval(10.0, 12.0 + 1.0)
            val item4 = Interval(11.0, 12.0 + 1.0)
            val item5 = Interval(12.0, 12.0 + 2.0)
            val item6 = Interval(12.0 + 1.0, 12.0 + 3.0)
            val item7 = Interval(12.0 + 1.0, 12.0 + 3.0)
            val item8 = Interval(12.0 + 3.0, 12.0 + 4.0)
            val item9 = Interval(12.0 + 3.0, 12.0 + 5.0)
            val item10 = Interval(12.0 + 3.0, 12.0 + 5.0)
            val input = listOf(item1, item2, item3, item4, item5, item6, item7, item8, item9, item10)

            val output = input.getMinNumOfPartitioning()
            assertEquals(3, output.size)
        }
        

    }


}