package ladder;

import ladder.controller.LadderGame;
import ladder.model.Player;
import ladder.model.Rows;
import ladder.view.ResultView;

import java.util.List;

public class MainApplication {
    public static void main(String[] args) {
        List<Player> players = LadderGame.ready();
        Rows rows = LadderGame.start(players.size());

        ResultView.printPlayers(players);
        ResultView.printRows(rows);
    }
}