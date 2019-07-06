package ladder;

import ladder.model.*;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        Players players = InputView.askPlayers();

        Rewards rewards = InputView.askRewards();

        int height = InputView.askHeight();

        Ladder ladder = Ladder.of(players.size(), height);

        OutputView.print(players, ladder, rewards);

    }
}
