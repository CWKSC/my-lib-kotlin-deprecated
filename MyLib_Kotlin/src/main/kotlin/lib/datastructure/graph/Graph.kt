package lib.datastructure.graph

abstract class Graph<Node, Weight> {

    val graph = HashMap<Node, HashMap<Node, Weight>>()

    abstract fun addEdge(nodeA: Node, nodeB: Node, weight: Weight)

}