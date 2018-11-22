package ladder.domain.generators

import ladder.domain.Player

object PlayerGenerator {
    fun generator(value: String): ArrayList<Player> {
        return value.split(",")
                .map { Player(it) }
                .toCollection(ArrayList())
    }
}
