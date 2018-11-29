package ladder.domain.generators

import ladder.domain.Point
import java.util.*

object RandomPointGenerator {
    private val random = Random()

    fun generator(countOfPerson: Int): List<Point> {
        val point = Point.first(randomPoint())
        val points = arrayListOf(point)
        for (i in 1 until countOfPerson) {
            points.add(points[i-1].next())
        }
        return points
    }

    fun randomPoint(): Boolean {
        return random.nextBoolean()
    }
}
