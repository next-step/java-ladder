package nextstep.ladder.controller;

import nextstep.ladder.domain.GameResult;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Players;
import nextstep.ladder.views.InputView;
import nextstep.ladder.views.ResultView;

public class LadderGameController {
    public void start(){
        Players players = Players.from(InputView.playerNames());
        Ladder ladder = Ladder.of(players.countOfPlayers(), InputView.maxLadderLength());

        GameResult gameResult = new GameResult(ladder, players);
        ResultView.showLadder(gameResult);
    }

}
