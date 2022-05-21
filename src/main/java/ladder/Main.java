package ladder;

import ladder.domain.Height;
import ladder.domain.Lines;
import ladder.domain.Players;
import ladder.generator.RandomBridgeGenerator;
import ladder.utils.InputUtil;
import ladder.view.InputView;
import ladder.view.OutputView;


public class Main {
    public static void main(String[] args) {
        Players players = Players.from(InputUtil.PlayerDelimiter(InputView.inputPlayer()));
        Lines lines = new Lines(new Height(InputView.inputLadderHeight()), players, new RandomBridgeGenerator());

        OutputView.printLadder(players, lines);
    }
}
