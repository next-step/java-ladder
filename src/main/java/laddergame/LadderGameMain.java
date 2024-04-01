package laddergame;

import laddergame.domain.HeightOfLadder;
import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.Players;
import laddergame.domain.ladder.PlayersAndWinningContents;
import laddergame.domain.ladder.WinningContents;
import laddergame.domain.ladder.strategy.RandomStrategy;

import static laddergame.view.InputView.*;
import static laddergame.view.OutputView.printExceptionMessage;
import static laddergame.view.OutputView.printExecutionResult;

public class LadderGameMain {
    public static void main(String[] arguments) throws Exception {
        try {
            PlayersAndWinningContents playersAndWinningContents = PlayersAndWinningContents.newPlayersAndWinnings(Players.valueOf(enteredPlayers()), WinningContents.valueOf(enteredWinnings()));

            HeightOfLadder heightOfLadder = enteredHeightOfLadder();
            Ladder ladder = Ladder.newLadder(heightOfLadder, playersAndWinningContents, new RandomStrategy());

            printExecutionResult(ladder);
        } catch (Exception e) {
            printExceptionMessage(e.getMessage());
        }
    }
}
