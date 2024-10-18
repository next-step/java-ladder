package laddergame.controller;

import laddergame.domain.*;
import laddergame.ui.InputView;
import laddergame.ui.ResultView;

import java.util.List;
import java.util.Optional;

public class LadderGame {

    private static final String ALL_PLAYERS = "all";

    private final InputView inputView;
    private final ResultView resultView;
    private final LadderLineGenerator generator;

    private Players players;
    private LadderPositionResult positionResult;
    private LadderPlayResult playResult;
    private Ladder ladder;

    public LadderGame(InputView inputView, ResultView resultView, LadderLineGenerator generator) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.generator = generator;
    }

    public void run() {
        initialize();
        showLadder();
        moveDown();
    }

    private void initialize() {
        this.players = getPlayers();
        this.positionResult = getPositionResult(players.size());
        this.playResult = new LadderPlayResult(positionResult);
        this.ladder = createLadder(players.size());
    }

    private void moveDown() {
        int firstPosition = players.firstPosition();
        int lastPosition = players.lastPosition();

        for (int position = firstPosition; position <= lastPosition; position++) {
            Optional<Player> optionalPlayer = players.findByPosition(position);
            int finalPosition = ladder.moveDownByPosition(position);

            optionalPlayer.ifPresent(player -> {
                playResult.add(player, finalPosition);
            });
        }
    }

    private void showLadder() {
        resultView.showLadder(players, ladder, positionResult);
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
