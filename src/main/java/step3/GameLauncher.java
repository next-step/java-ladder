package step3;

import step3.domain.LadderGame;
import step3.view.InputView;
import step3.view.ResultView;

import java.util.List;

public class GameLauncher {
    public static void main(String[] args) {
        List<String> names = InputView.inputNames();
        int height = InputView.inputLadderHeight();

        LadderGame ladderGame = new LadderGame(names, height);

        ResultView.printResult(ladderGame);
    }
}
