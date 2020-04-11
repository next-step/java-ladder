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

        ResultView.printLadder(players, rows, ladderPrizes);
    }

    public static void getResult() {
        GameResult gameResult = rows.getResult(players, ladderPrizes);

        GameResult resultToKnow1 = gameResult.findResultByPlayerName(InputView.getPlayerToGetResult());
        ResultView.printResult(resultToKnow1);

        GameResult resultToKnow2 = gameResult.findResultByPlayerName(InputView.getPlayerToGetResult());
        ResultView.printResult(resultToKnow2);
    }
}