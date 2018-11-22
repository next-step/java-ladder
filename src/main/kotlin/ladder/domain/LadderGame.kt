package ladder.domain

import ladder.domain.generators.PlayerGenerator

class LadderGame(private val values: String,
                 private val ladderHeight: Int) {

    fun getLadder(): Ladder {
        val players = PlayerGenerator.generator(values)
        return Ladder(players, ladderHeight)
    }
}
