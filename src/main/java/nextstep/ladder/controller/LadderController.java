package nextstep.ladder.controller;

import nextstep.ladder.model.*;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;
import java.util.Map;

public class LadderController {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        String peopleStr = inputView.inputPeople();
        People people = new People(peopleStr);

        String resultStr = inputView.inputResults();
        Results results = new Results(resultStr);

        int ladderHeight = inputView.inputLadderHeight();
        Ladder ladder = new Ladder(people.countPeople(), ladderHeight);
        Map<Person, Result> matches = ladder.getPersonResult(people.getPeople(), results.getResults());

        ResultView resultView = new ResultView();
        resultView.printLadder(people.getPeople(), results.getResults(), ladder.getLines());

        String name = inputView.inputResultOfPerson();
        resultView.printResults(name, people, matches);

    }
}
