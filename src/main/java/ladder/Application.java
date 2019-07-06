package ladder;

import ladder.model.Ladder;
import ladder.model.Player;
import ladder.model.Players;
import ladder.model.Reward;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        Players players = InputView.askPlayers();

        List<Reward> rewards = InputView.askRewards();

        int height = InputView.askHeight();

        Ladder ladder = Ladder.of(players.size(), height);

        OutputView.print(players, ladder, rewards);

    }
}
