package laddergame;

import laddergame.domain.HeightOfLadder;
import laddergame.domain.Players;
import laddergame.domain.Winnings;
import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.strategy.RandomStrategy;

import static laddergame.view.InputView.*;
import static laddergame.view.OutputView.printExceptionMessage;
import static laddergame.view.OutputView.printExecutionResult;

public class LadderGameMain {
    public static void main(String[] arguments) throws Exception {
        try {
            Players players = Players.valueOf(enteredPlayers());
            Winnings winnings = Winnings.valueOf(enteredWinnings());


            HeightOfLadder heightOfLadder = enteredHeightOfLadder();
            Ladder ladder = Ladder.newLadder(heightOfLadder, players, new RandomStrategy());

            printExecutionResult(players, ladder);
        } catch (Exception e) {
            printExceptionMessage(e.getMessage());
        }
    }
}
