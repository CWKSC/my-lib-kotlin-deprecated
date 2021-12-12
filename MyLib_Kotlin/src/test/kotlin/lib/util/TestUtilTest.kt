package lib.util

import lib.util.TestUtil.recordSystemOut
import lib.util.TestUtil.streamToSystemIn
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class TestUtilTest {

    @Test
    fun stream_input_into_system_in() {
        val input = streamToSystemIn("Hello World") {
            System.`in`.bufferedReader().readLine()
        }
        assertEquals("Hello World", input)
    }

    @Test
    fun record_output_from_system_out() {
        val output = recordSystemOut {
            print("Hello World")
        }
        assertEquals("Hello World", output)
    }

}