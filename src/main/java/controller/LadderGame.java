package controller;

import view.ConsoleInputView;
import view.InputView;

public class LadderGame {
    public static void runGame() {
        InputView inputView = new ConsoleInputView();
        inputView.getParticipantsNames();
        inputView.getHeightOfLadder();
    }
}
