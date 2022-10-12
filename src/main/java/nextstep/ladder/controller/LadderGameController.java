package nextstep.ladder.controller;

import java.util.List;

import nextstep.ladder.model.People;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderGameController {
    private final InputView inputView;
    private final ResultView resultView;

    public LadderGameController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        try {
            doRun();
        } catch (Exception e) {
            resultView.printError(e);
        }
    }

    private void doRun() {
        List<String> peopleNames = inputView.getPeopleNames();
        int ladderLength = inputView.getLadderLength();

        People people = new People(peopleNames);
        resultView.printResult(people);
    }
}
