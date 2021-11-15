package helper.testhelper

import helper.testhelper.TestHelper.Companion.recordSystemOut
import helper.testhelper.TestHelper.Companion.streamToSystemIn
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class TestHelperTest {

    @Test
    fun stream_input_into_system_in() {
        val input = streamToSystemIn("Hello World") {
            System.`in`.bufferedReader().readLine()
        }
        assertEquals("Hello World", input)
    }

    @Test
    fun record_ouput_from_system_out() {
        val output = recordSystemOut {
            print("Hello World")
        }
        assertEquals("Hello World", output)
    }

}