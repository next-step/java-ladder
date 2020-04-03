package ladder;

import ladder.controller.LadderGame;
import ladder.model.Players;
import ladder.model.Rows;
import ladder.view.ResultView;

public class MainApplication {
    public static void main(String[] args) {
        Players players = LadderGame.ready();
        Rows rows = LadderGame.start(players.getPlayerCount());

        ResultView.printLadder(players, rows);
    }
}