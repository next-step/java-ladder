package ladder.domain

class LadderGame(private val players: List<Player>,
                 private val ladder: Ladder) {

    fun ladderGameResult(result: String): LadderResult {
        val rewards = Rewards(result)
        return LadderResult(rewards, movedPositions())
    }

    private fun movedPositions(): PlayerPositions {
        return PlayerPositions(players, ladder)
    }
}
