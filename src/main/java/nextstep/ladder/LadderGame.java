package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderGame {

    public static void main(String... args) {
        Ladder ladder = Ladder.of(InputView.scanPlayerNames(),
                InputView.scanResults(), InputView.scanLadderHeight());

        ResultView.printLadder(ladder);
    }
}
