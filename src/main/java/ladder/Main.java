package ladder;

import ladder.model.Ladder;
import ladder.model.Players;

import static ladder.view.InputView.scanLadderHeight;
import static ladder.view.InputView.scanPlayersName;
import static ladder.view.OutputView.*;

public class Main {

    public static void main(String[] args) {
        Players players = Players.of(scanPlayersName());

        Ladder ladder = new Ladder(players.getPlayersCount(), scanLadderHeight());

        showResultMessage();
        showPlayersName(players);
        showLadder(ladder);
    }
}
