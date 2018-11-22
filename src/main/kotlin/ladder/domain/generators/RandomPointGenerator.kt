package ladder.domain.generators

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

    private fun hasPointBeforeMake(points: ArrayList<Boolean>): Boolean {
        return points[points.size-1]
    }

    private fun makePoint(point: Boolean): Boolean {
        if (point) {
            return false
        }
        return randomPoint()
    }

    private fun randomPoint(): Boolean {
        return random.nextBoolean()
    }
}
