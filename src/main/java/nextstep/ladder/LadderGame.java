package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.result.GameResult;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderGame {

    public static void main(String... args) {
        Ladder ladder = Ladder.of(InputView.scanPlayerNames(),
                InputView.scanResults(), InputView.scanLadderHeight());

        ResultView.printLadder(ladder);

        ResultView.printResults(ladder.getLadderResults());

        GameResult gameResult = GameResult.of(ladder);

        while (true) {
            ResultView.printGameResult(gameResult, InputView.scanPlayerName());
        }
    }
}
