package laddergame;

import laddergame.domain.Players;
import laddergame.domain.PlayersAndWinningContents;
import laddergame.domain.WinningContents;
import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.strategy.RandomStrategy;

import static laddergame.view.InputView.*;
import static laddergame.view.OutputView.*;

public class LadderGameMain {
    public static void main(String[] arguments) throws Exception {
        try {
            PlayersAndWinningContents playersAndWinningContents = PlayersAndWinningContents.newPlayersAndWinnings(Players.valueOf(enteredPlayers()), WinningContents.valueOf(enteredWinnings()));

            Ladder ladder = Ladder.newLadder(enteredHeightOfLadder(), playersAndWinningContents, new RandomStrategy());
            printLadderResult(playersAndWinningContents, ladder);

            printExecutionResult(playersAndWinningContents, ladder.resultOfLadder(playersAndWinningContents));
        } catch (Exception e) {
            printExceptionMessage(e.getMessage());
        }
    }
}
