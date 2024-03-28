package ladder2;

import ladder2.controller.LadderConsole;
import ladder2.view.InputView;
import ladder2.view.OutputView;

public class Main {

    public static void main(String[] args) {
        LadderConsole ladderConsole = new LadderConsole(new InputView(), new OutputView());
        ladderConsole.start();
    }
}
