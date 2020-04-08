package ladder.controller;

import ladder.model.player.Players;
import ladder.model.prize.LadderPrizes;
import ladder.model.result.GameResult;
import ladder.model.row.Rows;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderGame {
    public static void start() {
        Players players = Players.create(InputView.getPlayersInput());
        Rows rows = Rows.create(players, InputView.getHeight());
        LadderPrizes ladderPrizes = LadderPrizes.create(InputView.getLadderPrizesInput());

        ResultView.of(players, rows, ladderPrizes)
                .printLadder();
    }

    public static void getResult() {
        Players players = Players.getAllPlayers();
        Players playersForResult
                = players.findFinalLocationByName(Rows.getAllRows(), InputView.getPlayerToGetResult());

        ResultView.of(GameResult.create(playersForResult, LadderPrizes.getAllLadderPrizes()))
                .printResult();
    }
}