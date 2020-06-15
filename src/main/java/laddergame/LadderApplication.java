package laddergame;

import laddergame.domain.ladder.Height;
import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.BridgeGenerator;
import laddergame.domain.ladder.RandomConnectGenerator;
import laddergame.domain.player.Players;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class LadderApplication {
    public static void main(String[] args) {
        String[] names = InputView.inputPlayerNames();
        Players players = new Players(names);

        Height ladderHeight = new Height(InputView.inputLadderHeight());

        Ladder ladder = new Ladder(ladderHeight, names.length, new RandomConnectGenerator());

        OutputView.printLadder(players, ladder);
    }
}
