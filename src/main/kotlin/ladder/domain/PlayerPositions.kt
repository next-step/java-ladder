package ladder.domain

class PlayerPositions {
    private val positions: MutableMap<Player, Int> = hashMapOf()

    constructor(players: List<Player>, ladder: Ladder) {
        initPositions(players)
        move(ladder)
    }

    private fun initPositions(players: List<Player>) {
        players.forEachIndexed { index, player ->
            positions[player] = index
        }
    }

    private fun move(ladder: Ladder) {
        ladder.move(positions)
    }

    fun size() = positions.size

    override fun toString(): String {
        return "PlayerPositions(positions=$positions)"
    }

    fun get(player: Player): Int {
        return positions[player]?: throw IllegalArgumentException("존재하지 않는 유저입니다.")
    }

    fun allPlayers(): List<Player> {
        return positions.map { it.key }
    }
}
