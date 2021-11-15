package helper.testhelper

import java.io.ByteArrayOutputStream
import java.io.PrintStream

sealed class TestHelper {

    companion object {

        fun <T> streamToSystemIn(input: String, testCode: () -> T): T {
            val systemIn = System.`in`
            System.setIn(input.byteInputStream())
            try {
                return testCode()
            } finally {
                System.setIn(systemIn)
            }
        }

        fun recordSystemOut(testCode: () -> Unit): String {
            val systemOut = System.out
            val outputStream = ByteArrayOutputStream()
            System.setOut(PrintStream(outputStream))
            try {
                testCode()
            } finally {
                System.setOut(systemOut)
            }
            return outputStream.toString()
        }

    }


}