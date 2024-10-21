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
    private LadderResult ladderResult;
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
        showGameResult();
    }

    private void initialize() {
        this.players = getPlayers();
        this.ladderResult = getLadderResult(players.size());
        this.playResult = new LadderPlayResult();
        this.ladder = createLadder(players.size());
    }

    private void moveDown() {
        int firstPosition = 0;
        int lastPosition = players.size();

        for (int position = firstPosition; position < lastPosition; position++) {
            Optional<Player> optionalPlayer = players.findByPosition(position);
            int finalPosition = ladder.moveDownByPosition(position);

            optionalPlayer.ifPresent(player -> {
                String gameResult = this.ladderResult.findBy(finalPosition);
                playResult.add(player, gameResult);
            });
        }
    }

    private void showLadder() {
        resultView.showLadder(players, ladder, ladderResult);
    }

    private Players getPlayers() {
        List<Player> players = inputView.getPlayerFromUser();
        return new Players(players);
    }

    private LadderResult getLadderResult(int playerCount) {
        List<String> positonResult = inputView.getGameResultsFromUser(playerCount);
        return new LadderResult(positonResult);
    }

    private Ladder createLadder(int playerCount) {
        int ladderHeight = inputView.getMaxLadderHeightFromUser();;
        return new Ladder(playerCount, ladderHeight, generator);
    }

    private void showGameResult() {
        while(true){
            String playerName = inputView.getResultPlayerFromUser();
            Optional<Player> optionalPlayer = players.findByName(playerName);

            optionalPlayer.ifPresentOrElse(
                    (player) -> resultView.showGamePlayResult(player, playResult),
                    () -> resultView.showGamePlayResult(playResult)
            );
            if (isExit(playerName)) {
                return;
            }
        }
    }

    private boolean isExit(String playerName) {
        return playerName.equals(ALL_PLAYERS);
    }

}
