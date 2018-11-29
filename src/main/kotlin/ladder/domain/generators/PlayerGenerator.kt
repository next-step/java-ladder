package ladder.domain.generators

import ladder.domain.Player

object PlayerGenerator {
    fun generator(value: String): List<Player> {
        return value.split(",")
                .map { Player(it) }
                .toCollection(ArrayList())
    }
}
