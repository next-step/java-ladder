package ladder;

import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderGame {
    public static void start() {
        Players players = new Players(InputView.readNames());
        Ladder ladder = new Ladder(InputView.readHeight(), players.size(), new RandomPointStrategy());
        LadderResults.from(players, ladder);
        OutputView.printResult(players.players(), ladder);
    }
}
