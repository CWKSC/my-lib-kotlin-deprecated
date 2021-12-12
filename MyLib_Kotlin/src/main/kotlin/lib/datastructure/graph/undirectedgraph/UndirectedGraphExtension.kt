package lib.datastructure.graph.undirectedgraph

fun <Node> UndirectedGraph<Node, Int>.getTotalWeight() = getAllWeight().sum()

