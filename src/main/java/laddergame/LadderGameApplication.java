package laddergame;

import laddergame.component.LadderFactory;
import laddergame.component.RandomLadderLineFactory;
import laddergame.domain.LadderGame;
import laddergame.dto.LadderGameResult;
import laddergame.dto.LadderGameRunRequest;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class LadderGameApplication {

    public static void main(String[] args) {
        LadderGameRunRequest request = InputView.inputLadderGameRunRequest();
        LadderFactory ladderFactory = new LadderFactory(new RandomLadderLineFactory());
        LadderGame game = new LadderGame(ladderFactory);
        LadderGameResult result = game.run(request);
        OutputView.printResult(result);
    }

}
