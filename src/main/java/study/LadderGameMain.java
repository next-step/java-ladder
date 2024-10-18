package study;

import study.core.LadderGame;
import study.core.Line;
import study.core.PlayerName;
import study.view.InputView;
import study.view.ResultView;

import java.util.List;

public class LadderGameMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        List<PlayerName> names = inputView.inputNames();
        int height = inputView.inputHeight();
        LadderGame game = new LadderGame(names, height);
        List<Line> ladder= game.createLadder();
        resultView.printLadder(names, ladder);
    }
}
