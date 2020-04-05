package ladder.controller;

import ladder.model.*;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderGame {
    public static void start(InputView inputView) {
        Players players = inputView.getPlayers();
        Rows rows = Rows.create(players, inputView.getHeight());
        LadderPrizes ladderPrizes = LadderPrizes.create(inputView.getLadderPrizes());
        ResultView.of(players, rows).printLadder(ladderPrizes);

        LadderResult ladderResult = LadderResult.create(players, rows);
        LadderGameResult ladderGameResult = LadderGameResult.create(ladderResult, ladderPrizes);
        ResultView.of(players, rows).printGameResult(ladderGameResult, inputView.getStringPlayerToKnow());
    }
}