package nextstep.ladder.controller;

import nextstep.ladder.domain.*;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.Results;
import nextstep.ladder.views.InputView;
import nextstep.ladder.views.ResultView;

public class LadderGameController {
    public void start(){
        Players players = Players.from(InputView.playerNames());
        Results results = Results.from(InputView.gameResults());
        Ladder ladder = Ladder.of(players.countOfPlayers(), InputView.maxLadderLength());
        LadderResults ladderResults = LadderResults.of(ladder, results);
        GameResults gameResults = GameResults.of(ladderResults, players);

        ResultView.showPlayersNames(players.names());
        ResultView.showLadder(ladder.lines());
        ResultView.showResultValues(results.values());

        gameResults.showPlayerResults();
    }
}
