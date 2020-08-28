package com.hskim.ladder.controller;

import com.hskim.ladder.ui.LadderInputView;
import com.hskim.ladder.ui.LadderResultView;

public class LadderApplication {

    public static void main(String[] args) {

        LadderConsoleSimulator ladderConsoleSimulator = new LadderConsoleSimulator(new LadderInputView()
                , new LadderResultView());

        ladderConsoleSimulator.recruitParticipants();
        ladderConsoleSimulator.createLadder();
        ladderConsoleSimulator.printInitStatus();
    }
}
