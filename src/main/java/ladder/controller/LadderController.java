package ladder.controller;

import ladder.domain.Entry;
import ladder.domain.LadderGame;
import ladder.view.InputView;
import ladder.view.ResultView;


public class LadderController {
    public static void main(String[] args) {
        Entry entry = InputView.inputEntry();
        int height = InputView.inputHeight();

        LadderGame ladderGame = new LadderGame(entry.countOfPlayers(), height);

        ResultView.print(entry);
        ResultView.print(ladderGame.getLadder());
    }
}
