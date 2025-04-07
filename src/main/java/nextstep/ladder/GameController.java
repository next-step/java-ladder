package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.RandomPointStrategy;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

import java.util.Random;

public class GameController {
    public void start() {
        Players players = InputView.readPlayers();
        int height = InputView.readHeight();
        Ladder ladder = Ladder.of(height, players.numOfPlayers(), new RandomPointStrategy(new Random()));
        OutputView.printResult(players, ladder);
    }
}
