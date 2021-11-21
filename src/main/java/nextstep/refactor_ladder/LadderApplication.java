package nextstep.refactor_ladder;


import nextstep.refactor_ladder.controller.LadderController;
import nextstep.refactor_ladder.controller.dto.LadderCreateParam;
import nextstep.refactor_ladder.controller.dto.LadderResultParam;
import nextstep.refactor_ladder.domain.Ladder;
import nextstep.refactor_ladder.domain.LadderResults;
import nextstep.refactor_ladder.domain.value.ExecutionResult;
import nextstep.refactor_ladder.domain.value.Person;
import nextstep.refactor_ladder.service.LadderService;
import nextstep.refactor_ladder.strategy.RandomLadderStrategy;
import nextstep.refactor_ladder.ui.InputView;
import nextstep.refactor_ladder.ui.ResultView;

import java.util.List;

public class LadderApplication {
    private static final String ALL = "all";

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LadderController ladderController = new LadderController(new RandomLadderStrategy(), new LadderService());

        List<Person> people = inputView.inputPersonName();
        List<ExecutionResult> executionResults = inputView.inputExecutionResult();
        Integer heightOfLadder = inputView.inputHeightOfLadder();

        Ladder ladder = ladderController.createLadder(LadderCreateParam.of(people.size(), heightOfLadder));
        resultView.printLadder(people, ladder, executionResults);

        LadderResults ladderResults
                = ladderController.getLadderResults(LadderResultParam.of(people, ladder, executionResults));
        printResultOfLadder(inputView, resultView, ladderResults);
    }

    private static void printResultOfLadder(InputView inputView, ResultView resultView, LadderResults ladderResults) {
        while (true) {
            Person personName = inputView.inputResultOfPerson();

            if (ALL.equals(personName.getName())) {
                break;
            }

            resultView.printResultOfLadder(ladderResults, personName);
        }

        resultView.printResultOfAllLadder(ladderResults);
    }
}
