package automaton

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class DFATest {

    enum class InputType {
        text, `@`, dot, Unknowns
    }

    private fun charToInputType(c: Char): InputType = when (c) {
        in 'a'..'z', in 'A'..'Z', in '0'..'9', '_', '-' -> InputType.text
        '@' -> InputType.`@`
        '.' -> InputType.dot
        else -> InputType.Unknowns
    }

    @Test
    fun test_a_at_b_dot_com() {

        val dfa = DFA.create(
            "s1",
            "s1" to arrayOf(InputType.text to "s2"),
            "s2" to arrayOf(
                InputType.text to "s2",
                InputType.`@` to "s3"
            ),
            "s3" to arrayOf(InputType.text to "s4"),
            "s4" to arrayOf(
                InputType.text to "s4",
                InputType.dot to "s5"
            ),
            "s5" to arrayOf(InputType.text to "sF"),
            "sF" to arrayOf(
                InputType.text to "sF",
                InputType.dot to "s5"
            )
        )

        val stateList = "a@b.com".map {
            dfa.receive(charToInputType(it))
            return@map dfa.state
        }
        assertEquals(listOf("s2", "s3", "s4", "s5", "sF", "sF", "sF"), stateList)
    }

}