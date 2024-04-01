package laddergame;

import laddergame.domain.HeightOfLadder;
import laddergame.domain.Players;
import laddergame.domain.PlayersAndWinningContents;
import laddergame.domain.WinningContents;
import laddergame.domain.ladder.Ladder;
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

            printExecutionResult(playersAndWinningContents, ladder);
        } catch (Exception e) {
            printExceptionMessage(e.getMessage());
        }
    }
}
