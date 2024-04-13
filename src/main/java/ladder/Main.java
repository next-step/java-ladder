package ladder;

import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Main {
    public static void main(String[] args) {
        Players players = InputView.scanPlayersNames();
        int height = InputView.scanHeight();

        Ladder ladder = Ladder.of(height, players.getCount());
        OutputView.printLadderWithPlayer(players, ladder);
    }
}
