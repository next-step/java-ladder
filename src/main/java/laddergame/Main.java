package laddergame;

import laddergame.domain.LadderGame;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class Main {
    public static void main(String[] args) {
        String namesString = InputView.inputUsers();
        int maxLadderHeight = InputView.inputMaxLadderHeight();
        LadderGame ladderGame = new LadderGame(namesString, maxLadderHeight);

        OutputView.printGameMap(ladderGame.getUserNames(), ladderGame.getLadder());
    }
}
