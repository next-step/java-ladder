package ladder;

import ladder.model.Ladder;
import ladder.model.LadderCreator;
import ladder.model.Players;

import static ladder.view.InputView.scanLadderHeight;
import static ladder.view.InputView.scanPlayersName;
import static ladder.view.OutputView.*;

public class Main {

    public static void main(String[] args) {
        Players players = new Players(scanPlayersName());

        LadderCreator ladderCreator = new LadderCreator(players.getPlayersSize(), scanLadderHeight());

        Ladder ladder = new Ladder(ladderCreator);

        showResultMessage();
        showPlayersName(players);
        showLadder(ladder);
    }
}
