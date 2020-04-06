package ladder.controller;

import ladder.model.player.Players;
import ladder.model.prize.LadderPrizes;
import ladder.model.result.GameResult;
import ladder.model.result.PositionResult;
import ladder.model.row.Rows;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderGame {
    private static Players players;
    private static Rows rows;
    private static LadderPrizes ladderPrizes;

    public static void start(InputView inputView) {
        players = Players.create(inputView.getPlayers());
        rows = Rows.create(players, inputView.getHeight());
        ladderPrizes = LadderPrizes.create(inputView.getLadderPrizes());

        ResultView.of(players, rows).printLadder(ladderPrizes);
    }

    public static void getResult(InputView inputView) {
        PositionResult finalLocationByName = players.findFinalLocationByName(rows, inputView.getPlayerToGetResult());
        GameResult gameResult = GameResult.create(finalLocationByName, ladderPrizes);

        ResultView.printResult(gameResult);
    }
}