package lib.datastructure.graph.undirectedgraph

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class UndirectedGraphEdgeTest {

    @Nested
    inner class EqualTest {

        @Test
        fun `Exchange node, should return true`() {
            val edge1 = UndirectedGraphEdge(1, 2, 42)
            val edge2 = UndirectedGraphEdge(2, 1, 42)
            assertTrue(edge1 == edge2)
        }

        @Test
        fun `Same node in set`() {
            val edge1 = UndirectedGraphEdge(1, 2, 42)
            val edge2 = UndirectedGraphEdge(2, 1, 42)
            val set = setOf(edge1, edge2)
            assertEquals(1, set.size)
        }

    }

}