package ladder.domain

import ladder.domain.generators.RandomPointGenerator

class Point {
    private val left: Boolean
    private val right: Boolean

    constructor(left: Boolean, right: Boolean) {
        if (left && right) {
            throw IllegalArgumentException()
        }
        this.left = left
        this.right = right
    }

    fun next(nextRight: Boolean): Point {
        return of(left = this.right, right = nextRight)
    }

    fun next(): Point {
        if (this.right) {
            return next(false)
        }
        val random = RandomPointGenerator.randomPoint()
        return next(random)
    }

    override fun toString(): String {
        return "Point(left=$left, right=$right)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Point

        if (left != other.left) return false
        if (right != other.right) return false

        return true
    }

    override fun hashCode(): Int {
        var result = left.hashCode()
        result = 31 * result + right.hashCode()
        return result
    }

    companion object {
        fun of(left: Boolean, right: Boolean): Point = Point(left, right)

        fun first(right: Boolean): Point = of(false, right)

        fun last(left: Boolean): Point = of(left, false)
    }
}
