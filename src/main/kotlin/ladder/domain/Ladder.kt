package ladder.domain

class Ladder {
    var lines: List<Line>
        private set
    var players: List<Player>
        private set

    constructor(players: List<Player>, ladderHeight: Int) {
        if (ladderHeight < MIN_LADDER_HEIGHT) {
            throw IllegalArgumentException("사다리 높이는 최소 1 이상이어야 합니다.")
        }
        this.players = players
        this.lines = getLines(players, ladderHeight)
    }

    constructor(players: List<Player>, lines: List<Line>) {
        this.players = players
        this.lines = lines
    }

    private fun getLines(players: List<Player>, ladderHeight: Int): List<Line> {
        val lines = arrayListOf<Line>()
        for (i in 0 until ladderHeight) {
            lines.add(Line(players.size))
        }
        return lines
    }

    fun drawLadder(): String =
            StringBuilder().apply {
                append(Line.START_EMPTY_SPACES)
                append(getPlayerNames())
                append("\n")
                append(getLines())
            }.toString()

    private fun getPlayerNames(): String = players.joinToString(" ") { it.name }

    private fun getLines(): String = lines.joinToString("\n") { it.drawLine() }

    companion object {
        private const val MIN_LADDER_HEIGHT = 1
    }
}
