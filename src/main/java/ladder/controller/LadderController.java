package ladder.controller;

import ladder.domain.*;
import ladder.domain.rule.AlwaysDrawRule;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {

    public void start() {
        Players players = Players.of(InputView.inputPlayerNames());

        LadderGame ladderGame = LadderGame.builder()
                .players(players)
                .rows(InputView.inputLineCount())
                .build();
        Ladder ladder = ladderGame.makeLadder(new AlwaysDrawRule());

        ResultView.printPlayers(players);
        ResultView.printLadder(ladder);
    }
}
