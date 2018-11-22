package ladder.view

import ladder.domain.Ladder

object ResultView {
    fun showResult(ladder: Ladder) {
        println(ladder.drawLadder())
    }
}
