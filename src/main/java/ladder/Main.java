package ladder;

import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.domain.RandomPointGenerationStrategy;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> names = InputView.printPlayers();
        Players players = new Players(names);

        int height = InputView.printHeight();

        Ladder ladder = new Ladder(players, new Height(height), new RandomPointGenerationStrategy());

        OutputView.printResult(players, ladder);
    }
}
