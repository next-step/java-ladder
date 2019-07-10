package ladder;

import ladder.io.InputView;
import ladder.io.OutputView;

public class LadderMain {
    public static void main(String[] args) {
        String inputNames = InputView.inputNames();
        Players players = new Players(inputNames);

        String height = InputView.inputLadderHeight();
        Ladder ladder = Ladder.of(Integer.valueOf(height), players.getSize());

        OutputView.printNames(players);
        OutputView.printLadder(ladder);
    }
}
