package nextstep.ladder.controller;

import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.People;
import nextstep.ladder.model.Results;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderController {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        String peopleStr = inputView.inputPeople();
        People people = new People(peopleStr);

        String resultStr = inputView.inputResults();
        Results results = new Results(resultStr);


        int ladderHeight = inputView.inputLadderHeight();

        Ladder ladder = new Ladder(people.getPeople().size(), ladderHeight);

        ResultView resultView = new ResultView();
        resultView.printLadder(people.getPeople(), results.getResults(), ladder.getLines());

        ladder.startMove(people);

        String name = inputView.inputResultOfPerson();
        resultView.printResult(name, people, results.getResults());

    }
}
