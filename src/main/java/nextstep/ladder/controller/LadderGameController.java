package nextstep.ladder.controller;

import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.People;
import nextstep.ladder.model.Rewards;
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
        People people = new People(inputView.getPeopleNames());
        Rewards rewards = new Rewards(inputView.getRewards(), people.getPeopleCount());

        int ladderLength = inputView.getLadderLength();
        Ladder ladder = new Ladder(ladderLength, people.getPeopleCount());

        resultView.printResult(people, ladder, rewards);
    }
}
