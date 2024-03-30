package laddergame;

import laddergame.domain.HeightOfLadder;
import laddergame.domain.Players;
import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.strategy.RandomStrategy;

import static laddergame.view.InputView.enteredHeightOfLadder;
import static laddergame.view.InputView.enteredPlayers;
import static laddergame.view.OutputView.printExceptionMessage;
import static laddergame.view.OutputView.printExecutionResult;

public class LadderGameMain {
    public static void main(String[] arguments) throws Exception {
        try {
            Players players = Players.valueOf(enteredPlayers());
            HeightOfLadder heightOfLadder = enteredHeightOfLadder();
            Ladder ladder = Ladder.newLadder(heightOfLadder.height(), players.numberOfPlayers(), new RandomStrategy());

            printExecutionResult(players, ladder);
        } catch (Exception e) {
            printExceptionMessage(e.getMessage());
        }
    }
}
