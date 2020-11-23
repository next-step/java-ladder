package nextstep.ladder;

import nextstep.ladder.view.ConsoleInputView;
import nextstep.ladder.view.ConsoleResultView;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class ApplicationExecutor {
    public static void main(String[] args) {
        LadderGame ladderGame = getLadderGame();
        ladderGame.start();
    }

    private static LadderGame getLadderGame() {
        return new LadderGame(getInputView(), getResultView());
    }

    private static InputView getInputView() {
        return new ConsoleInputView();
    }

    private static ResultView getResultView() {
        return new ConsoleResultView();
    }
}
