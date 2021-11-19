package nextstep.ladder;

import nextstep.ladder.controller.LadderController;
import nextstep.ladder.controller.dto.LadderCreateParam;
import nextstep.ladder.doamin.Ladder;
import nextstep.ladder.doamin.LadderResult;
import nextstep.ladder.doamin.fcatory.LineFactory;
import nextstep.ladder.doamin.value.Person;
import nextstep.ladder.strategy.RandomLineStrategy;
import nextstep.ladder.ui.InputView;
import nextstep.ladder.ui.ResultView;

import java.util.List;

public class LadderApplication {
    private static final String EXIT = "exit";

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LadderController ladderController = new LadderController(new RandomLineStrategy(), new LineFactory());

        List<Person> people = inputView.inputPersonName();
        List<String> executionResult = inputView.inputExecutionResult(people);
        Integer heightOfLadder = inputView.inputHeightOfLadder();

        Ladder ladder = ladderController.createLadder(LadderCreateParam.of(people, heightOfLadder));
        LadderResult ladderResult = LadderResult.of(people, ladder, executionResult);
        resultView.printLadder(ladderResult);

        printResultOfLadder(inputView, resultView, ladderResult);
    }

    private static void printResultOfLadder(InputView inputView, ResultView resultView, LadderResult ladderResult) {
        while (true) {
            Person personName = inputView.inputResultOfPerson();

            if (EXIT.equals(personName.getName())) {
                break;
            }

            resultView.printResultOfLadder(ladderResult, personName);
        }
    }
}
