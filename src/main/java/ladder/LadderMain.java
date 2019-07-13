package ladder;

import ladder.io.InputView;
import ladder.io.OutputView;

public class LadderMain {
    public static void main(String[] args) {
        String inputNames = InputView.inputNames();
        Players players = new Players(inputNames);

        int height = InputView.inputLadderHeight();
        Ladder ladder = Ladder.of(height, players.getSize());

        Results results = Results.of(InputView.inputResults());
        OutputView.printNames(players);
        OutputView.printLadder(ladder);
        OutputView.printResults(results);
    }
}
