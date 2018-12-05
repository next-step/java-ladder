package ladder.domain

class Rewards(reward: String) {
    private val rewards: List<String> = split(reward)

    fun get(index: Int): String {
        return rewards[index]
    }

    fun size(): Int = rewards.size

    private fun split(reward: String) = reward.split(",")

    override fun toString(): String {
        return rewards.joinToString("\t")
    }
}
