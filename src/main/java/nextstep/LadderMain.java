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
        List<String> inputResults = InputView.inputResults();
        checkInput(inputResults, inputNames);

        LadderGame ladderGame = new LadderGame(inputNames, height, new RandomGeneratorStrategy());
        OutputView.printPlayers(ladderGame.getPlayers());
        OutputView.printLadder(ladderGame.getLines());
    }

    private static void checkInput(List<String> inputResults, List<String> inputNames) {
        if (inputResults.size() != inputNames.size()) {
            throw new IllegalArgumentException("Input results size is not equal to input names size.");
        }
    }
}
