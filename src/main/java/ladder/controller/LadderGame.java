package ladder.controller;

import ladder.model.player.Players;
import ladder.model.prize.LadderPrizes;
import ladder.model.result.GameResult;
import ladder.model.row.Rows;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderGame {
    public static ResultView start(InputView inputView) {
        Players players = Players.create(inputView.getPlayersInput());
        Rows rows = Rows.create(players, inputView.getHeight());
        LadderPrizes ladderPrizes = LadderPrizes.create(inputView.getLadderPrizesInput());

        return ResultView.of(players, rows, ladderPrizes);
    }

    public static ResultView getResult(InputView inputView) {
        Players players = inputView.getPlayers();
        Players playersForResult
                = players.findFinalLocationByName(inputView.getRows(), inputView.getPlayerToGetResult());

        return ResultView.of(GameResult.create(playersForResult, inputView.getLadderPrizes()));
    }
}