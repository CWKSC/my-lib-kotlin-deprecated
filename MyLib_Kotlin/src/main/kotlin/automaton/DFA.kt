package automaton

data class DFA<State, Input>(
    val initState: State,
    var state: State = initState,
    val graph: HashMap<State, HashMap<Input, State>> = hashMapOf(),
    val output: MutableList<State> = mutableListOf()
) {

    companion object {
        fun <State, Input> create(
            initState: State,
            vararg pairs: Pair<State, Array<Pair<Input, State>>>
        ): DFA<State, Input> {
            val dfa = DFA<State, Input>(initState)
            dfa(*pairs)
            return dfa
        }
    }

    init {
        graph[initState] = hashMapOf()
    }

    operator fun get(state: State): HashMap<Input, State> {
        if (state !in graph) {
            graph[state] = hashMapOf()
        }
        return graph[state]!!
    }

    operator fun invoke(vararg pairs: Pair<State, Array<Pair<Input, State>>>) {
        for (pair in pairs) {
            val rules = HashMap<Input, State>()
            rules.putAll(pair.second)
            graph[pair.first] = rules
        }
    }

    fun receive(input: Input) {
        state = get(state)[input]!!
    }

}