package nextstep.refactor_ladder;


import nextstep.refactor_ladder.controller.LadderController;
import nextstep.refactor_ladder.controller.dto.LadderCreateParam;
import nextstep.refactor_ladder.domain.Ladder;
import nextstep.refactor_ladder.strategy.RandomLadderStrategy;
import nextstep.refactor_ladder.ui.InputView;
import nextstep.refactor_ladder.ui.ResultView;

import java.util.List;

public class LadderApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LadderController ladderController = new LadderController(new RandomLadderStrategy());

        List<String> people = inputView.inputPersonName();
        List<String> executionResults = inputView.inputExecutionResult();
        Integer heightOfLadder = inputView.inputHeightOfLadder();

        Ladder ladder = ladderController.createLadder(LadderCreateParam.of(people.size(), heightOfLadder));
        resultView.printLadder(people, ladder, executionResults);
    }
}
