package nextstep.ladder.controller;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Players;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;

public class LadderMachine {

    public void run() {
        List<String> playerNames = InputView.getPlayerNames();
        Players players = Players.from(playerNames);
        int height = InputView.getHeightOfLadder();
        Ladder ladder = new Ladder(height, players.countOfPerson());
        ResultView.showPlayers(players.readOnlyPlayerNames());
        ResultView.showLadder(ladder.readOnlyLadder());
    }
}
