package ladder;

import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.domain.RandomPointGenerationStrategy;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Main {
    public static void main(String[] args) {
        Players players = new Players(InputView.printPlayers());
        Height height = new Height(InputView.printHeight());

        Ladder ladder = new Ladder(players, height, new RandomPointGenerationStrategy());

        OutputView.printResult(players, ladder);
    }
}
