package ladder

import ladder.domain.LadderGame
import ladder.domain.LadderResult
import ladder.domain.PlayerPositions
import ladder.domain.Rewards
import ladder.view.InputView
import ladder.view.ResultView

fun main(args: Array<String>) {
    val players: String = InputView.getInputString("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)")
//    val result: String = InputView.getInputString("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)")
    val ladderHeight: Int = InputView.getInputNumber("최대 사다리 높이는 몇 개인가요?")
    val ladderGame = LadderGame(players, ladderHeight)
    ResultView.showLadder(ladderGame.getLadder())
//
//    val ladderResult: LadderResult = ladderGame.ladderGameResult(result)
//    while (true) {
//        val who: String = InputView.getInputString("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)")
//        ResultView.showResult(ladderResult.showResult(who))
//    }

}
