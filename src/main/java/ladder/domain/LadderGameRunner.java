package ladder.domain;

import ladder.view.InputView;

public class LadderGameRunner {
    public static void main(String[] args) {
        LadderGame game = new LadderGame(
                InputView.promptThenString("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)"),
                InputView.promptThenInt("최대 사다리 높이는 몇 개인가요?")
        );
        game.start();
    }
}
