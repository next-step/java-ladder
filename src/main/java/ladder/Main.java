package ladder;

import ladder.controller.LadderConsole;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Main {

    public static void main(String[] args) {
        LadderConsole ladderConsole = new LadderConsole(new InputView(), new OutputView());
        ladderConsole.start();
    }
}
