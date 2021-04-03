package nextstep.ladder.controller;

import nextstep.ladder.domain.GameResult;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Players;
import nextstep.ladder.views.InputView;
import nextstep.ladder.views.ResultView;

public class LadderGameController {
    private Players players;

    public Players generatePlayers(String value) {
        return new Players(value);
    }

    public Ladder generateLadder(String value) {
        return new Ladder(players.countOfPlayers(), Integer.parseInt(value));
    }

    public void start(){
        players = generatePlayers(InputView.playerNames());
        Ladder ladder = generateLadder(InputView.maxLadderLength());

        GameResult gameResult = new GameResult(ladder, players);
        ResultView.showLadder(gameResult);
    }

}
