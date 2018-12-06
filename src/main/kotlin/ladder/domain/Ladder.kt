package ladder.domain

class Ladder {
    private val players: List<Player>
    private var lines: List<Line>
    private val level: Level

    constructor(players: List<Player>, ladderLevel: String) {
        this.level = Level.findLevel(ladderLevel)
        this.players = players
        this.lines = getLines(players, level.getHeight())
    }

    // 테스트를 위해 필요
    constructor(players: List<Player>, lines: List<Line>, level: Level) {
        this.level = level
        this.players = players
        this.lines = lines
    }

    private fun getLines(players: List<Player>, ladderHeight: Int): List<Line> {
        val lines = arrayListOf<Line>()
        for (i in 0 until ladderHeight) {
            lines.add(Line(players.size, level))
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

    fun move(positions: MutableMap<Player, Int>) {
        lines.forEach { line ->
            movePlayers(positions, line)
        }
    }

    private fun movePlayers(positions: MutableMap<Player, Int>, line: Line) {
        players.forEach { player ->
            positions[player] = line.move(positions[player]!!)
        }
    }

    override fun toString(): String {
        return "Ladder(lines=$lines, players=$players)"
    }

    companion object {
        private const val MIN_LADDER_HEIGHT = 1
    }
}
