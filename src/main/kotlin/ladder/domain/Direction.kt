package ladder.domain

import java.lang.Boolean.FALSE
import java.lang.Boolean.TRUE

enum class Direction(private val point: Point, val position: Int) {
    LEFT(Point(TRUE, FALSE), -1),
    RIGHT(Point(FALSE, TRUE), 1),
    CURRENT(Point(FALSE, FALSE), 0);

    private fun hasPoint(point: Point): Boolean {
        return this.point == point
    }

    companion object {
        fun findDirection(point: Point): Direction {
            return values().find { it.hasPoint(point) } ?: CURRENT
        }
    }
}
