package laddergame;

import laddergame.domain.LadderGame;
import laddergame.view.InputView;

public class Main {
    String namesString = InputView.inputUsers();
    int maxLadderHeight = InputView.inputMaxLadderHeight();
    LadderGame ladderGame = new LadderGame(namesString, maxLadderHeight);
}
