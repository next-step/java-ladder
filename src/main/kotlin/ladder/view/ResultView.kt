package ladder.view

import ladder.domain.Ladder
import ladder.domain.Rewards

object ResultView {
    fun showLadder(ladder: Ladder) {
        println(ladder.drawLadder())
    }

    fun showResult(ladderResult: String) {
        val result = StringBuffer("실행 결과\n").apply {
            append(ladderResult)
        }.toString()
        println(result)
    }

    fun showRewards(result: String) {
        println(Rewards(result))
    }
}
