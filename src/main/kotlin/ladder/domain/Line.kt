package ladder.domain

import ladder.domain.generators.RandomPointGenerator

class Line {
    var points: List<Point>
        private set

    constructor(countOfPerson: Int) {
        this.points = RandomPointGenerator.generator(countOfPerson)
    }

    constructor(points: List<Point>) {
        this.points = points
    }

    fun drawLine(): String {
        val line = StringBuilder(START_EMPTY_SPACES + VERTICAL)
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
        val direction = Direction.findDirection(point)
        return if (direction == Direction.RIGHT) DASH else SPACE
    }

    fun position(index: Int): Int {
        val direction = Direction.findDirection(points[index])
        return direction.position
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
