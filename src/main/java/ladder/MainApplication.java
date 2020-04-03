package ladder;

import ladder.model.Player;
import ladder.model.Rows;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class MainApplication {
    public static void main(String[] args) {
        List<Player> players = InputView.getPlayers();
        int height = InputView.getHeight();

        ResultView.printPlayers(players);
        ResultView.printRows(Rows.create(players.size(),height), players);
    }
}