package laddergame;

import laddergame.domain.LadderGame;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class Main {
    public static void main(String[] args) {
        String namesString = InputView.inputUsers();
        int maxLadderHeight = InputView.inputMaxLadderHeight();
        String resultsString = InputView.inputResults();

        LadderGame ladderGame = new LadderGame(namesString, resultsString, maxLadderHeight);
        OutputView.printGameMap(ladderGame.getUserNames(), ladderGame.getResults(), ladderGame.getLadder());

        String target = InputView.inputTarget();
        OutputView.printResult(ladderGame.play(), target);
    }
}
