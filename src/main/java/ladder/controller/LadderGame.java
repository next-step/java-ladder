package ladder.controller;

import ladder.model.Players;
import ladder.model.Rows;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderGame {
    public static ResultView start(InputView inputView) {
        Players players = inputView.getPlayers();
        Rows rows = Rows.create(players, inputView.getHeight());

        return new ResultView(players, rows);
    }
}