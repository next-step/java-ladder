package ladder.domain.generators

import ladder.domain.Point
import java.util.*

object RandomPointGenerator {
    private val random = Random()

    fun generator(countOfPerson: Int): List<Point> {
        val points = arrayListOf<Point>()
        val point = first()
        points.add(point)
        body(countOfPerson, points)
        if(countOfPerson > 1) {
            points.add(last(points))
        }
        return points
    }

    private fun first() = Point.first(randomPoint())

    private fun body(countOfPerson: Int, points: MutableList<Point>) {
        for (i in 1 until countOfPerson -1) {
            points.add(points[i-1].next())
        }
    }

    private fun last(points: MutableList<Point>) = points[points.size-1].last()

    fun randomPoint(): Boolean {
        return random.nextBoolean()
    }
}
