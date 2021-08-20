package nextstep.ladder;

import nextstep.view.InputView;
import nextstep.view.ResultView;

public class main {

    public static void main(String[] args) {
        ExecuteLadderGame executeLadderGame = ExecuteLadderGame.of(InputView.insertPlayer(), InputView.insertLadderHeight());
        ResultView.printLadderResult(executeLadderGame);
    }
}
