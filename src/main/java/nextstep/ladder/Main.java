package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class Main {
    public static void main(String[] args) {
        String names = InputView.inputNames();
        int height = InputView.inputLadderHeight();

        Ladder ladderGame = new Ladder(names, height);

        ResultView.printResult(ladderGame);
    }
}
