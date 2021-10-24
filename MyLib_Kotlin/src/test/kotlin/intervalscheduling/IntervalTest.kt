package intervalscheduling

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class IntervalTest {

    @Test
    fun test_p_function(){
        val intervals = arrayOf(
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
        assertEquals(results, listOf(-1, -1, -1, 0, 1, 0, 2, 4))
    }


}