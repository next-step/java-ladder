package step04.controller;

import step04.ui.LadderInputView;
import step04.ui.LadderResultView;

public class LadderApplication {

    public static void main(String[] args) {
        LadderConsoleSimulator ladderConsoleSimulator = new LadderConsoleSimulator(new LadderInputView(),
                new LadderResultView());

        ladderConsoleSimulator.recruitParticipants();
        ladderConsoleSimulator.setRewards();
        ladderConsoleSimulator.createLadder();
        ladderConsoleSimulator.printInitStatus();
        ladderConsoleSimulator.simulate();
        ladderConsoleSimulator.checkResult();
    }
}
