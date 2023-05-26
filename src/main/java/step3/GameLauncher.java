package step3;

import step3.domain.LadderGame;
import step3.domain.Names;
import step3.domain.Results;
import step3.view.InputView;
import step3.view.ResultView;

import java.util.List;

public class GameLauncher {
    public static void main(String[] args) {
        Names names = new Names(InputView.inputNames());
        Results results = new Results(InputView.inputResults(), names.size());
        int height = InputView.inputLadderHeight();

        LadderGame ladderGame = new LadderGame(names, height);

        ResultView.printResult(ladderGame, results);
    }
}
