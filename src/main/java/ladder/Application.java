package ladder;

import ladder.domain.ladder.Ladder;
import ladder.domain.player.Players;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> playerNames = InputView.inputPlayerNames();
        Players players = Players.from(playerNames);

        int ladderHeights = InputView.inputLadderHeights();
        
        Ladder ladder = Ladder.of(players, ladderHeights);

        OutputView.printLadder(ladder);
    }
}
