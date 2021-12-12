package lib.datastructure.graph

class DisjointSet<Node>(data: Collection<Node>) {

    private val disjointSet = mutableMapOf(*data.map { it to it }.toTypedArray())

    fun find(node: Node): Node {
        if (disjointSet[node] == node) return node
        val parent = find(disjointSet[node]!!)
        disjointSet[node] = parent
        return disjointSet[node]!!
    }

    fun union(a: Node, b: Node) {
        val aParent = find(a)
        val bParent = find(b)
        if (aParent == bParent) return
        disjointSet[bParent] = aParent
    }


}