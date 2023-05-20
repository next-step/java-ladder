package step2;

import step2.domain.LadderGame;
import step2.view.InputView;

import java.util.List;

public class GameLauncher {
    public static void main(String[] args) {
        List<String> names = InputView.inputNames();
        int height = InputView.inputLadderHeight();

        LadderGame ladderGame = new LadderGame(names, height);
    }
}
