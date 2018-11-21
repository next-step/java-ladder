package ladder

import ladder.domain.Players
import ladder.view.InputView

fun main(args: Array<String>) {
    val value = InputView.getInputString("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)")
    val lines = InputView.getInputNumber("최대 사다리 높이는 몇 개인가요?")
    val players = Players.ofComma(value)
    players.players.forEach {
        println(it)
    }
}