package ladder.domain

import ladder.domain.generators.PlayerGenerator

class LadderGame(private val values: String,
                 private val ladderHeight: Int) {

    fun getLadder(): Ladder {
        return Ladder(getPlayers(), ladderHeight)
    }

    fun ladderGameResult(result: String): LadderResult {
        val rewards = Rewards(result)
        val playerPositions = result()
        return LadderResult(rewards, playerPositions)
    }

    fun result(): PlayerPositions {
        val playerPositions = PlayerPositions(getPlayers())
        for (index in 0 until getPlayers().size) {
            calculateLadder(index, playerPositions)
        }
        return playerPositions
    }

    fun calculateLadder(index: Int, playerPositions: PlayerPositions) {
        val lines = getLadder().lines
        val players = getPlayers()
        lines.forEach { line ->
//            val position = line.position(index)
//            playerPositions.move(players[index], position)
        }
    }

    private fun getPlayers(): List<Player> = PlayerGenerator.generator(values)
}
