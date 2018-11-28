package ladder.domain

import java.lang.Boolean.FALSE
import java.lang.Boolean.TRUE

enum class Direction(private val point: Point) {
    LEFT(Point(TRUE, FALSE)),
    RIGHT(Point(FALSE, TRUE)),
    CURRENT(Point(FALSE, FALSE));

    private fun hasPoint(point: Point): Boolean {
        return this.point == point
    }

    companion object {
        fun findDirection(point: Point): Direction {
            return values().find { it.hasPoint(point) } ?: CURRENT
        }
    }
}
