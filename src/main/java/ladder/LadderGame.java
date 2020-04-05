package ladder;

import ladder.domain.Gamers;
import ladder.domain.ladder.Ladder;
import ladder.ui.InputView;
import ladder.ui.OutputView;

public class LadderGame {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    private void start() {
        Gamers gamers = Gamers.ofComma(inputView.getGamers());
        Ladder ladder = Ladder.of(inputView.getheight(), gamers.getGamerList().size() - 1);

        outputView.printGamers(gamers);
        outputView.printLadder(ladder);
    }

    public static void main(String[] args) {
        new LadderGame().start();
    }
}
