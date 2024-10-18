package laddergame.controller;

import laddergame.domain.Ladder;
import laddergame.domain.LadderLineGenerator;
import laddergame.domain.Player;
import laddergame.domain.Players;
import laddergame.ui.InputView;
import laddergame.ui.ResultView;

import java.util.List;

public class LadderGame {
    private final InputView inputView;
    private final ResultView resultView;
    private final LadderLineGenerator generator;

    public LadderGame(InputView inputView, ResultView resultView, LadderLineGenerator generator) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.generator = generator;
    }

    public void run() {
        Players players = getPlayers();
        Ladder ladder = createLadder(players.size());
        resultView.showLadderGameResult(players, ladder);
    }

    private Players getPlayers() {
        List<Player> players = inputView.getPlayerFromUser();
        return new Players(players);
    }

    private Ladder createLadder(int playerCount) {
        int ladderHeight = inputView.getMaxLadderHeightFromUser();;
        return new Ladder(playerCount, ladderHeight, generator);
    }

}
