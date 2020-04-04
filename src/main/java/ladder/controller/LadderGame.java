package ladder.controller;

import ladder.model.Players;
import ladder.model.Rows;
import ladder.view.InputView;

public class LadderGame {
    public static Players ready() {
        return InputView.getPlayers();
    }

    public static Rows start(int playerCount) {
        return Rows.create(playerCount, InputView.getHeight());
    }
}