package ladder.domain;

import ladder.domain.ladder.Ladder;
import ladder.domain.player.Players;
import ladder.domain.util.RightPointRandom;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderGame {
    public void run() {
        Players players = new Players(InputView.inputGamePlayers());
        Ladder ladder = new Ladder(players.getPlayerCount(), InputView.inputLadderSize(),
                new RightPointRandom());
        ResultView.printLadderResult(players, ladder.getLines());
    }
}
