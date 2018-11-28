package ladder.domain

class Ladder {
    var lines: ArrayList<Line>
        private set
    var players: ArrayList<Player>
        private set

    constructor(players: ArrayList<Player>, ladderHeight: Int) {
        if (ladderHeight < MIN_LADDER_HEIGHT) {
            throw IllegalArgumentException("사다리 높이는 최소 1 이상이어야 합니다.")
        }
        this.players = players
        this.lines = getLines(players, ladderHeight)
    }

    constructor(players: ArrayList<Player>, lines: ArrayList<Line>) {
        this.players = players
        this.lines = lines
    }

    private fun getLines(players: ArrayList<Player>, ladderHeight: Int): ArrayList<Line> {
        val lines = arrayListOf<Line>()
        for (i in 0..ladderHeight) {
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
