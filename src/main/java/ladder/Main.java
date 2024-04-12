package ladder;

import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Player> players = InputView.scanPlayersNames();
        int height = InputView.scanHeight();

        Ladder ladder = Ladder.of(height, players.size());
        OutputView.printLadderWithPlayer(players, ladder);
    }
}
