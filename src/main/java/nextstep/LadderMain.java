package nextstep;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderMain {
    public static void main(String[] args) {
        String inputNames = InputView.inputNames();
        int height = InputView.inputLadderHeight();

        LadderGame ladderGame = new LadderGame(inputNames, height);
        OutputView.printPlayers(ladderGame.getPlayers());
        OutputView.printLadder(ladderGame.getLines());
    }
}
