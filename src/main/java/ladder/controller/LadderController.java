package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.LadderGame;
import ladder.domain.Players;
import ladder.domain.rule.AlwaysDrawRule;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {

    public void start() {
        Players players = Players.of(InputView.inputPlayerNames());

        LadderGame ladderGame = new LadderGame(players, InputView.inputLineCount());
        Ladder ladder = ladderGame.makeLadder(new AlwaysDrawRule());

        ResultView.printPlayers(players);
        ResultView.printLadder(ladder);
    }
}
