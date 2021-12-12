package lib.datastructure.graph.undirectedgraph


class UndirectedGraphEdge<Node, Weight>(val nodeA: Node, val nodeB: Node, val weight: Weight) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as UndirectedGraphEdge<*, *>

        if (nodeA == other.nodeA && nodeB == other.nodeB) return true
        if (nodeA == other.nodeB && nodeB == other.nodeA) return true
        if (weight != other.weight) return false

        return true
    }

    override fun hashCode(): Int {
        var result = nodeA.hashCode() * nodeB.hashCode()
        result = 31 * result + weight.hashCode()
        return result
    }

    override fun toString(): String {
        return "UndirectedGraphEdge(nodeA=$nodeA, nodeB=$nodeB, weight=$weight)"
    }

}

