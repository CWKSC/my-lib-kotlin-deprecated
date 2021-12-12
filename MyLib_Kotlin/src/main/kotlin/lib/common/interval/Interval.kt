package lib.common.interval

open class Interval(val start: Double, val finish: Double) {

    override fun toString(): String {
        return "Interval(start=$start, finish=$finish)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Interval

        if (start != other.start) return false
        if (finish != other.finish) return false

        return true
    }

    override fun hashCode(): Int {
        var result = start.hashCode()
        result = 31 * result + finish.hashCode()
        return result
    }

}