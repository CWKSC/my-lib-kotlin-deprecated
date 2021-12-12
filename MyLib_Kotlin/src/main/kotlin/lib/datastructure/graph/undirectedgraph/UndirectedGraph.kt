package lib.datastructure.graph.undirectedgraph

import lib.datastructure.graph.Graph

class UndirectedGraph<Node, Weight> : Graph<Node, Weight>() {

    override fun addEdge(nodeA: Node, nodeB: Node, weight: Weight) {
        graph.computeIfAbsent(nodeA) { hashMapOf() }[nodeB] = weight
        graph.computeIfAbsent(nodeB) { hashMapOf() }[nodeA] = weight
    }

    fun getAllEdge(): MutableSet<UndirectedGraphEdge<Node, Weight>> {
        val edgeSet = mutableSetOf<UndirectedGraphEdge<Node, Weight>>()
        graph.forEach { edgeMap ->
            val from = edgeMap.key
            edgeMap.value.forEach { edge ->
                val to = edge.key
                val value = edge.value
                edgeSet.add(UndirectedGraphEdge(from, to, value))
            }
        }
        return edgeSet
    }

    fun getEdgeFrom(from: Node): List<UndirectedGraphEdge<Node, Weight>> {
        val edgeList = mutableListOf<UndirectedGraphEdge<Node, Weight>>()
        graph[from]!!.forEach { edge ->
            val to = edge.key
            val value = edge.value
            edgeList.add(UndirectedGraphEdge(from, to, value))
        }
        return edgeList
    }

    fun getAllNode(): MutableSet<Node> = graph.keys

    fun getAllWeight(): List<Weight> = getAllEdge().map { it.weight }

    fun size(): Int = graph.size

}

