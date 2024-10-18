package laddergame.controller;

import laddergame.domain.*;
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
        LadderPositionResult positionResult = getPositionResult(players.size());
        Ladder ladder = createLadder(players.size());
        resultView.showLadderGameResult(players, ladder);
    }

    private Players getPlayers() {
        List<Player> players = inputView.getPlayerFromUser();
        return new Players(players);
    }

    private LadderPositionResult getPositionResult(int playerCount) {
        List<String> positonResult = inputView.getGameResultsFromUser(playerCount);
        return new LadderPositionResult(positonResult);
    }

    private Ladder createLadder(int playerCount) {
        int ladderHeight = inputView.getMaxLadderHeightFromUser();;
        return new Ladder(playerCount, ladderHeight, generator);
    }

}
