package nextstep.ladder;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class Main {
    public static void main(String[] args) {
        String names = InputView.inputNames();
        int height = InputView.inputLadderHeight();

        LadderGame ladderGame = new LadderGame(names, height);

        ResultView.printResult(ladderGame);
    }
}
