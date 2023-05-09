package ladder;

import ladder.service.LadderGame;
import ladder.view.InputView;
import ladder.view.ResultView;

public class Application {
    public static void main(String[] args) {
        LadderGame ladderGame = new LadderGame();

        ladderGame.setPlayer(InputView.enterPlayers());
        ladderGame.setHeight(InputView.enterHeight());

        ResultView.getResultHeader();
    }
}
