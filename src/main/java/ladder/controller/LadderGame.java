package ladder.controller;

import ladder.model.Player;
import ladder.model.Rows;
import ladder.view.InputView;

import java.util.List;

public class LadderGame {
    public static List<Player> ready() {
        return InputView.getPlayers();
    }

    public static Rows start(int playerCount){
        return Rows.create(playerCount, InputView.getHeight());
    }
}
