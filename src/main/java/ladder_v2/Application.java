package ladder_v2;

import ladder.domain.Height;
import ladder.domain.Names;
import ladder_v2.domain.*;
import ladder_v2.view.InputView;
import ladder_v2.view.OutputView;

import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) {
        Players players = InputView.inputNames();
        Rewards rewards = InputView.inputRewards();
        Height height = InputView.inputHeight();

        Ladder ladder = new Ladder(players.names().size(), height);
        GameResult result = new LadderGame().play(players, rewards, ladder);

        OutputView.printLadderResult(players, ladder, rewards);
        Name name = InputView.inputResult();
        OutputView.printFinalResult(name, result);

    }
}
