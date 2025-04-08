package ladder;

import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderApplication {
    public static void main(String[] args) {
        Players players = Players.of(InputView.getPlayerNames());
        Height ladderHeight = new Height(InputView.getLadderHeight());

        Ladder ladder = Ladder.generateRandomLadder(players, ladderHeight);
        OutputView.printGeneratedLadderResult(players, ladder);
    }
}
