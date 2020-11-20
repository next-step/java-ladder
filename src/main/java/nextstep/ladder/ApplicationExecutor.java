package nextstep.ladder;

import nextstep.ladder.view.ConsoleInputView;
import nextstep.ladder.view.ConsoleResultView;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class ApplicationExecutor {
    public static void main(String[] args) {
        LadderGame ladderGame = ladderGame();
        ladderGame.start();
    }

    private static LadderGame ladderGame() {
        return new LadderGame(inputView(), resultView());
    }

    private static InputView inputView() {
        return new ConsoleInputView();
    }

    private static ResultView resultView() {
        return new ConsoleResultView();
    }
}
