package ladder.domain.generators

import ladder.domain.Point
import java.util.*

object RandomPointGenerator {
    private val random = Random()

    fun generator(countOfPerson: Int): ArrayList<Boolean> {
        val points = arrayListOf(false)
        for (i in 1 until countOfPerson) {
            points.add(makePoint(hasPointBeforeMake(points)))
        }
        return points
    }

    fun generator2(countOfPerson: Int): ArrayList<Point> {
        val point = Point.first(randomPoint())
        val points = arrayListOf(point)
        for (i in 1 until countOfPerson) {
            points.add(points[i-1].next())
        }
        return points
    }

    private fun hasPointBeforeMake(points: ArrayList<Boolean>): Boolean {
        return points[points.size-1]
    }

    private fun makePoint(point: Boolean): Boolean {
        if (point) {
            return false
        }
        return randomPoint()
    }

    fun randomPoint(): Boolean {
        return random.nextBoolean()
    }
}
