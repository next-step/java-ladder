package laddergame.main;

import laddergame.game.LadderGame;
import laddergame.ui.InputView;
import laddergame.ui.ResultView;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        String names = inputView.userNames();
        int height = inputView.ladderHeight();
        LadderGame game = LadderGame.valueOf(names, height);

        ResultView resultView = new ResultView();
        resultView.showResult(game.userNames(), game.ladderLines());
    }
}
