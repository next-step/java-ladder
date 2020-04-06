package ladder;

import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        Players players = inputView.inputPlayerName();
        Height height = inputView.inputHeight();

        Ladder ladder = new Ladder(players.count(), height);

        OutputView.printPlayerName(players);
        OutputView.printLadder(ladder);
    }
}
