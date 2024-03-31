package nextstep.ladder;

import nextstep.ladder.application.LadderService;
import nextstep.ladder.domain.LineGenerator;
import nextstep.ladder.infra.RandomLineGenerator;
import nextstep.ladder.presentation.InputView;
import nextstep.ladder.presentation.LadderController;
import nextstep.ladder.presentation.ResultView;

public class LadderApplication {
    public static void main(String[] args) {
        LineGenerator lineGenerator = new RandomLineGenerator();
        LadderService ladderService = new LadderService(lineGenerator);

        ResultView resultView = new ResultView();
        InputView inputView = new InputView();
        LadderController ladderController = new LadderController(ladderService, resultView, inputView);

        ladderController.startGame();
    }
}
