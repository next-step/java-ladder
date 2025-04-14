package ladder;

import ladder.domain.LadderGame;
import ladder.view.InputView;
import ladder.view.ResultView;

public class Main {

    public static void main(String[] args) {
        LadderGame ladderGame = new LadderGame(new InputView(), new ResultView());
        ladderGame.run();
    }
}
