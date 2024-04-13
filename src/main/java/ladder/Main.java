package ladder;

import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.domain.Results;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Players players = InputView.scanPlayersNames();
        Results results = InputView.scanResult();
        int height = InputView.scanHeight();

        Ladder ladder = Ladder.of(height, players.getCount());
        OutputView.printLadderWithPlayer(players, ladder, results);
    }
}
