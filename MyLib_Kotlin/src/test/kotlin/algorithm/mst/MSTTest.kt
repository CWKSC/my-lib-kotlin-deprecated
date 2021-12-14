package algorithm.mst

import algorithm.mst.MST.kruskal
import algorithm.mst.MST.prim
import lib.datastructure.graph.undirectedgraph.UndirectedGraph
import lib.datastructure.graph.undirectedgraph.getTotalWeight
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class MSTTest {

    // Reference: https://www.researchgate.net/figure/Example-of-Minimum-spanning-tree-11_fig2_330778836
    // Min total weight: 27
    // In reference website, it said it is 33 cost, but actually 27.
    private val undirectedGraph1 = UndirectedGraph<Int, Int>()

    init {
        undirectedGraph1.addEdge(1, 2, 1)
        undirectedGraph1.addEdge(1, 3, 9)
        undirectedGraph1.addEdge(1, 6, 14)
        undirectedGraph1.addEdge(2, 3, 10)
        undirectedGraph1.addEdge(2, 4, 15)
        undirectedGraph1.addEdge(3, 4, 11)
        undirectedGraph1.addEdge(3, 6, 2)
        undirectedGraph1.addEdge(4, 5, 6)
        undirectedGraph1.addEdge(5, 6, 9)
    }

    @Test
    fun test_undirectedGraph1_kruskal() {
        assertEquals(27, undirectedGraph1.kruskal().getTotalWeight())
    }

    @Test
    fun test_undirectedGraph1_prim() {
        val minWeights = undirectedGraph1.getAllNode().map {
            undirectedGraph1.prim(it).getTotalWeight()
        }
        assertEquals(List(undirectedGraph1.size()) { 27 }, minWeights)
    }

    @RepeatedTest(30)
    fun test_undirectedGraph1_prim_random_start_point() {
        assertEquals(27, undirectedGraph1.prim().getTotalWeight())
    }

    // Reference: https://www.geeksforgeeks.org/prims-minimum-spanning-tree-mst-greedy-algo-5/
    // Min total weight: 37
    private val undirectedGraph2 = UndirectedGraph<Int, Int>()

    init {
        undirectedGraph2.addEdge(0, 1, 4)
        undirectedGraph2.addEdge(0, 7, 8)
        undirectedGraph2.addEdge(1, 2, 8)
        undirectedGraph2.addEdge(1, 7, 11)
        undirectedGraph2.addEdge(2, 3, 7)
        undirectedGraph2.addEdge(2, 5, 4)
        undirectedGraph2.addEdge(2, 8, 2)
        undirectedGraph2.addEdge(3, 4, 9)
        undirectedGraph2.addEdge(3, 5, 14)
        undirectedGraph2.addEdge(4, 5, 10)
        undirectedGraph2.addEdge(5, 6, 2)
        undirectedGraph2.addEdge(6, 7, 1)
        undirectedGraph2.addEdge(6, 8, 6)
        undirectedGraph2.addEdge(7, 8, 7)
    }


    @Test
    fun test_undirectedGraph2_kruskal() {
        assertEquals(37, undirectedGraph2.kruskal().getTotalWeight())
    }

    @Test
    fun test_undirectedGraph2_prim() {
        val minWeights = undirectedGraph2.getAllNode().map {
            undirectedGraph2.prim(it).getTotalWeight()
        }
        assertEquals(List(undirectedGraph2.size()) { 37 }, minWeights)
    }

    @RepeatedTest(30)
    fun test_undirectedGraph2_prim_random_start_point() {
        assertEquals(37, undirectedGraph2.prim().getTotalWeight())
    }



    // Have cycle
    private val undirectedGraph_cycle = UndirectedGraph<Int, Int>()

    init {
        undirectedGraph_cycle.addEdge(0, 0, 8)
        undirectedGraph_cycle.addEdge(0, 1, 5)
        undirectedGraph_cycle.addEdge(0, 2, 5)
        undirectedGraph_cycle.addEdge(1, 0, 5)
        undirectedGraph_cycle.addEdge(1, 1, 11)
        undirectedGraph_cycle.addEdge(1, 2, 5)
        undirectedGraph_cycle.addEdge(2, 0, 5)
        undirectedGraph_cycle.addEdge(2, 1, 5)
        undirectedGraph_cycle.addEdge(2, 2, 25)
    }

    @Test
    fun test_undirectedGraph_cycle_kruskal() {
        assertEquals(10, undirectedGraph_cycle.kruskal().getTotalWeight())
    }

    @Test
    fun test_undirectedGraph_cycle_prim() {
        val minWeights = undirectedGraph_cycle.getAllNode().map {
            val mst = undirectedGraph_cycle.prim(it)
            val weight = mst.getTotalWeight()
            weight
        }
        assertEquals(List(undirectedGraph_cycle.size()) { 10 }, minWeights)
    }


    @RepeatedTest(1000)
    fun random_node_edge() {
        val randomGraph = UndirectedGraph<Int, Int>()
        val getRandomNode = { (0..3).random() }
        val getRandomWeight = { (1..30).random() }
        randomGraph.addEdge(getRandomNode(), getRandomNode(), getRandomWeight())
        repeat(30) {
            val from = randomGraph.getAllNode().random()
            val to = getRandomNode()
            val weight = getRandomWeight()
            randomGraph.addEdge(from, to, weight)
        }
        println(randomGraph)
        assertEquals(randomGraph.kruskal().getTotalWeight(), randomGraph.prim().getTotalWeight())
    }

}