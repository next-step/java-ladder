package ladder;

import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Application {

    public static void main(String[] args) {
        Players players = Players.of(InputView.askPlayers());
        Height height = Height.from(InputView.askHeight());

        Ladder ladder = Ladder.from(players, height);

        OutputView.printResult(players, ladder);
    }
}
