package ladder.controller;

import ladder.model.player.Players;
import ladder.model.prize.LadderPrizes;
import ladder.model.result.GameResult;
import ladder.model.row.Rows;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderGame {
    private static Players players;
    private static Rows rows;
    private static LadderPrizes ladderPrizes;

    public static void start() {
        players = Players.create(InputView.getPlayersInput());
        rows = Rows.create(players, InputView.getHeight());
        ladderPrizes = LadderPrizes.create(InputView.getLadderPrizesInput());

        ResultView.of(players, rows, ladderPrizes)
                .printLadder();
    }

    public static void getResult() {
        Players playersForResult
                = players.findFinalLocationByName(rows, InputView.getPlayerToGetResult());

        ResultView.of(GameResult.create(playersForResult, ladderPrizes))
                .printResult();
    }
}