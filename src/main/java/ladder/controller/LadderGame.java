package ladder.controller;

import ladder.model.player.Players;
import ladder.model.prize.LadderPrizes;
import ladder.model.row.Rows;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.Map;

public class LadderGame {
    public static void start(InputView inputView) {
        Players players = inputView.getPlayers();
        Rows rows = Rows.create(players, inputView.getHeight());
        LadderPrizes ladderPrizes = LadderPrizes.create(inputView.getLadderPrizes());
        ResultView.of(players, rows).printLadder(ladderPrizes);

        Map<String, Integer> finalLocationByName
                = players.findFinalLocationByName(rows, inputView.getPlayerToGetResult());

    }
}