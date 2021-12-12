package algorithm.mst

import lib.datastructure.graph.DisjointSet
import lib.datastructure.graph.undirectedgraph.UndirectedGraph

object MST {

    fun <Node, Weight : Comparable<Weight>> UndirectedGraph<Node, Weight>.kruskal(): UndirectedGraph<Node, Weight> {
        val allEdge = getAllEdge().sortedBy { it.weight; }
        val allNode = getAllNode()
        val mst = UndirectedGraph<Node, Weight>()
        val disjointSet = DisjointSet(allNode)
        for (edge in allEdge) {
            val nodeA = edge.nodeA
            val nodeB = edge.nodeB
            if (disjointSet.find(nodeA) == disjointSet.find(nodeB)) continue
            mst.addEdge(nodeA, nodeB, edge.weight)
            disjointSet.union(nodeA, nodeB)
        }
        return mst
    }

    fun <Node, Weight : Comparable<Weight>> UndirectedGraph<Node, Weight>.prim(_start: Node? = null): UndirectedGraph<Node, Weight> {
        val start = _start ?: graph.keys.random()
        val mst = UndirectedGraph<Node, Weight>()
        val visited = mutableSetOf(start)
        val edgeList = getEdgeFrom(start).toMutableList()
        while (visited.size != graph.size) {
            edgeList.sortBy { it.weight }
            val minEdge = edgeList.removeFirst()
            val from = minEdge.nodeA
            val to = minEdge.nodeB
            val weight = minEdge.weight
            visited.add(to)
            mst.addEdge(from, to, weight)
            edgeList.addAll(getEdgeFrom(to))
            edgeList.removeAll { visited.contains(it.nodeB) }
        }
        return mst
    }

}