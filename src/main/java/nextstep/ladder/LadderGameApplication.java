package nextstep.ladder;

import nextstep.ladder.controller.LadderGameController;
import nextstep.ladder.domain.LadderGameMaker;
import nextstep.ladder.domain.ladder.LadderFactory;
import nextstep.ladder.domain.ladder.LineFactory;
import nextstep.ladder.domain.ladder.RandomLineFactory;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderGameApplication {

    public static void main(String[] args) {
        LineFactory lineFactory = new RandomLineFactory();
        LadderFactory ladderFactory = new LadderFactory(lineFactory);
        LadderGameMaker ladderGameMaker = new LadderGameMaker(ladderFactory);

        LadderGameController ladderGameController = new LadderGameController(ladderGameMaker);

        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        ladderGameController.run(inputView, resultView);
    }
}
