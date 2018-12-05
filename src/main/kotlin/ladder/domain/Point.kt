package ladder.domain

class Point(private val position: Int,
            private val direction: Direction) {

    fun move(): Int {
        if (direction.isRight()) {
            return position + 1
        }

        if (direction.isLeft()) {
            return position - 1
        }

        return position
    }

    fun next(): Point {
        return Point(position + 1, direction.next())
    }

    fun next(right: Boolean): Point {
        return Point(position + 1, direction.next(right))
    }

    fun last(): Point {
        return Point(position + 1, direction.last())
    }

    fun getDirection() = direction

    override fun toString(): String {
        return "Point(position=$position, direction=$direction)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Point

        if (position != other.position) return false
        if (direction != other.direction) return false

        return true
    }

    override fun hashCode(): Int {
        var result = position
        result = 31 * result + direction.hashCode()
        return result
    }

    companion object {
        fun first(right: Boolean): Point {
            return Point(0, Direction.first(right))
        }
    }
}
