package ladder.view

import ladder.domain.Ladder
import ladder.domain.LadderResult

object ResultView {
    fun showLadder(ladder: Ladder) {
        println(ladder.drawLadder())
    }

    fun showResult(ladderResult: LadderResult) {
//        println(ladderResult.showResult())
    }
}
