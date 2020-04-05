package ladder.controller;

import ladder.model.LadderPrizes;
import ladder.model.Players;
import ladder.model.Rows;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderGame {
    public static void start(InputView inputView) {
        Players players = inputView.getPlayers();
        Rows rows = Rows.create(players, inputView.getHeight());
        LadderPrizes ladderPrizes = LadderPrizes.create(inputView.getLadderPrizes());
        ResultView.of(players, rows).printLadder();


        String input = inputView.getPlayerToKnowResult();
    }
}