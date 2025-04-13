package ladder;

import ladder.domain.LadderGame;
import ladder.view.InputView;

public class Main {

    public static void main(String[] args) {
        LadderGame ladderGame = new LadderGame(new InputView());
        ladderGame.run();
    }
}
