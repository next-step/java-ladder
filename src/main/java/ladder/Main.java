package ladder;

import ladder.view.InputView;
import ladder.view.OutputView;

public class Main {
    public static void main(String[] args) {
        Players players = InputView.inputPlayers();
        int height = InputView.inputHeight();

        Ladder ladder = new Ladder(height, players.size());

        OutputView.outputLadderGameResult(players, ladder);
    }
}
