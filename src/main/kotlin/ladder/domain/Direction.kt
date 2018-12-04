package ladder.domain

import ladder.domain.generators.RandomPointGenerator

class Direction {
    private val left: Boolean
    private val right: Boolean

    constructor(left: Boolean, right: Boolean) {
        if (left && right) {
            throw IllegalArgumentException()
        }
        this.left = left
        this.right = right
    }

    fun next(nextRight: Boolean): Direction {
        return of(left = this.right, right = nextRight)
    }

    fun next(): Direction {
        if (this.right) {
            return next(false)
        }
        val random = RandomPointGenerator.randomPoint()
        return next(random)
    }

    fun last(): Direction {
        return of(this.right, false)
    }

    fun isLeft(): Boolean = left

    fun isRight(): Boolean = right

    fun isCurrent(): Boolean = !left && !right

    override fun toString(): String {
        return "Direction(left=$left, right=$right)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Direction

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
        fun of(left: Boolean, right: Boolean): Direction {
            if (left && right) {
                throw IllegalArgumentException()
            }
            if (left && !right) {
                return LEFT_DIRECTION
            }
            if (!left && right) {
                return RIGHT_DIRECTION
            }
            return CURRENT_DIRECTION
        }

        fun first(right: Boolean): Direction {
            return of(false, right)
        }

        private val LEFT_DIRECTION = Direction(true, false)
        private val RIGHT_DIRECTION = Direction(false, true)
        private val CURRENT_DIRECTION = Direction(false, false)
    }
}
