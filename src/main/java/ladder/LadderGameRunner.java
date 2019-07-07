package ladder;

import ladder.domain.LadderGame;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderGameRunner {
    public static void main(String[] args) {
        LadderGame game = new LadderGame(
                InputView.promptThenString("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)"),
                InputView.promptThenString("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)"),
                InputView.promptThenInt("최대 사다리 높이는 몇 개인가요?")
        );
        ResultView.printResult(game.start());
    }
}
