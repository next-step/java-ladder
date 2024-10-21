package laddergame.controller;

import laddergame.domain.*;
import laddergame.io.LadderGameIOHandler;
import laddergame.ui.InputView;
import laddergame.ui.ResultView;

import java.util.Optional;

public class LadderGameApplication {

    private static final String ALL_PLAYERS = "all";

    public static void main(String[] args) {
        LadderGameIOHandler ioHandler = new LadderGameIOHandler(new InputView(), new ResultView());
        InputView inputView = ioHandler.getInputView();
        ResultView resultView = ioHandler.getResultView();

        LadderLineGenerator generator = new RandomLineGenerator();

        Players players = inputView.getPlayerFromUser();
        int playerCount = players.size();

        LadderResult ladderResult = inputView.getGameResultsFromUser(playerCount);

        int ladderHeight = inputView.getMaxLadderHeightFromUser();;
        Ladder ladder =  new Ladder(playerCount, ladderHeight, generator);

        resultView.showLadder(players, ladder, ladderResult);

        LadderGame game = new LadderGame(players, ladder, ladderResult);
        LadderPlayResult playResults = game.play();

        showGameResult(ioHandler, players, playResults);

    }

    private static void showGameResult(LadderGameIOHandler ioHandler, Players players, LadderPlayResult playResults) {
        InputView inputView = ioHandler.getInputView();
        ResultView resultView = ioHandler.getResultView();

        while(true){
            String playerName = inputView.getResultPlayerFromUser();
            Optional<Player> optionalPlayer = players.findByName(playerName);

            optionalPlayer.ifPresentOrElse(
                    (player) -> resultView.showGamePlayResult(player, playResults),
                    () -> resultView.showGamePlayResult(playResults)
            );

            if (isExit(playerName)) {
                return;
            }
        }
    }

    private static boolean isExit(String playerName) {
        return playerName.equals(ALL_PLAYERS);
    }
}
