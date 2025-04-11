package nextstep;

import java.util.List;
import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.RandomGeneratorStrategy;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderMain {
    public static void main(String[] args) {
        List<String> inputNames = InputView.inputNames();
        int height = InputView.inputLadderHeight();

        LadderGame ladderGame = new LadderGame(inputNames, height, new RandomGeneratorStrategy());
        OutputView.printPlayers(ladderGame.getPlayers());
        OutputView.printLadder(ladderGame.getLines());
    }
}
