package ladder

import ladder.domain.*
import ladder.domain.generators.PlayerGenerator
import ladder.view.InputView
import ladder.view.ResultView

fun main(args: Array<String>) {
    val playerNames: String = InputView.getInputString("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)")
    val result: String = InputView.getInputString("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)")
    val ladderHeight: Int = InputView.getInputNumber("최대 사다리 높이는 몇 개인가요?")

    val players = PlayerGenerator.generator(playerNames)
    val ladder = Ladder(players, ladderHeight)
    val ladderGame = LadderGame(players, ladder)

    ResultView.showLadder(ladder)
    ResultView.showRewards(result)

    val ladderResult: LadderResult = ladderGame.ladderGameResult(result)
    while (true) {
        val who: String = InputView.getInputString("결과를 보고 싶은 사람은?")
        ResultView.showResult(ladderResult.showResult(who))
    }
}
