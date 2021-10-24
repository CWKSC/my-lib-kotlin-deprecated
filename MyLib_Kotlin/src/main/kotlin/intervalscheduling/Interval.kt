package intervalscheduling

open class Interval(open val start: Double, open val finish: Double)

fun <T : Interval> Array<T>.p(index: Int): Int {
    val start = this[index].start

    for (i in (index - 1) downTo 0) {
        if (this[i].finish > start) continue
        return i
    }
    return -1
}

