package ladder.domain

class PlayerPositions {
    private val positions: MutableMap<Player, Int> = hashMapOf()
    constructor(players: ArrayList<Player>) {
        initPositions(players)
    }

    private fun initPositions(players: ArrayList<Player>) {
        players.forEachIndexed { index, player ->
            positions[player] = index
        }
    }

    fun move(player: Player, position: Int) {
        val movePosition = positions[player]!! + position
        if (isOverLadder(movePosition)) {
            throw IllegalArgumentException("사다리 이동 범위를 벗어났습니다.")
        }
        positions[player] = movePosition
    }

    fun size(): Int = positions.size

    private fun isOverLadder(movePosition: Int) = movePosition !in 0 until positions.size

    fun get(player: Player): Int {
        return positions[player]!!
    }

    fun allPlayers(): List<Player> {
        return positions.map { it.key }
    }
}
