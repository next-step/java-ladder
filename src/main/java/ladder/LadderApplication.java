package ladder;

import ladder.domain.Height;
import ladder.domain.Players;
import ladder.view.InputView;

public class LadderApplication {
    public static void main(String[] args) {
        Players players = Players.of(InputView.getPlayerNames());
        Height ladderHeight = new Height(InputView.getLadderHeight());
    }
}
