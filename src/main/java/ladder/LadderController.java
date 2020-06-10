package ladder;

import ladder.domain.ladder.Ladder;
import ladder.domain.player.Players;
import ladder.domain.strategy.RandomLineStrategy;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {

    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public void run() {
        Players players = Players.of(inputView.inputPlayers());
        int height = inputView.inputHeight();
        Ladder ladder = Ladder.of(players.getCountOfPerson(), height, new RandomLineStrategy());
        resultView.printLadder(players, ladder);
    }

    public static void main(String[] args) {
        new LadderController().run();
    }
}
