package ladder.domain

import ladder.domain.generators.RandomPointGenerator

class Line {
    var points: List<Point>
        private set

    constructor(countOfPerson: Int, level: Level) {
        this.points = RandomPointGenerator.generator(countOfPerson, level)
    }

    constructor(points: List<Point>) {
        this.points = points
    }

    fun drawLine(): String {
        val line = StringBuilder(START_EMPTY_SPACES)

        if (points.size == 1) {
            line.append(VERTICAL)
            return line.toString()
        }

        for (i in 0 until points.size) {
            line.append(VERTICAL)
            line.append(drawFillToEmptyRoom(getFillCharacter(points[i])))
        }

        return line.toString()
    }

    private fun drawFillToEmptyRoom(fillCharacter: String): String {
        val fillText = StringBuilder()
        for (i in 0 until Player.MAX_NAME_SIZE) {
            fillText.append(fillCharacter)
        }
        return fillText.toString()
    }

    private fun getFillCharacter(point: Point): String {
        point.next()
        val direction = point.getDirection()
        return if (direction.isRight()) DASH else SPACE
    }

    fun move(position: Int): Int {
        return points[position].move()
    }

    override fun toString(): String {
        return "Line(points=$points)"
    }

    companion object {
        const val START_EMPTY_SPACES = "     "
        private const val VERTICAL = "|"
        private const val SPACE = " "
        private const val DASH = "-"
    }
}
