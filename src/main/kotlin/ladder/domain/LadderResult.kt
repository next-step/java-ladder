package ladder.domain

class LadderResult {
    private val rewards: Rewards
    private val playerPositions: PlayerPositions

    constructor(rewards: Rewards, playerPositions: PlayerPositions) {
        if(rewards.size() != playerPositions.size()) {
            throw IllegalArgumentException("보상과 플레이어의 수가 일치하지 않습니다.")
        }
        this.rewards = rewards
        this.playerPositions = playerPositions
    }

    fun showResult(text: String): String {
        if (ALL == text) {
            return showAllPlayerRewards()
        }
        return singlePlayerReward(text)
    }

    private fun singlePlayerReward(name: String): String {
        val position = playerPositions.get(Player(name))
        return rewards.get(position)
    }

    private fun showAllPlayerRewards(): String =
            playerPositions
                    .allPlayers()
                    .joinToString("\n") { player ->
                        val playerPosition = playerPositions.get(player)
                        "${player.name} : ${rewards.get(playerPosition)}"
                    }

    companion object {
        const val ALL = "all"
    }
}
