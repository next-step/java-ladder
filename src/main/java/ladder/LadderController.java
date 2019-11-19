package ladder;

import ladder.domain.*;
import ladder.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LadderController {

    private LadderService ladderService;

    public LadderController() {
        ladderService = new LadderService();
    }

    public People execute(String names, int height, String result) {
        People people = new People(names);
        Lines lines = ladderService.createLines(height, people.size());
        people.matchResult(lines.getLadderLines());
        Results results = new Results(result);
        ResultView.print(lines, people, results);
        return people;
    }

    public void displayResultOfAll(People people, String name, String result) {
        Results results = new Results(result);
        int resultIndex = people.getPerson(name).getPosition();
        ResultView.printResultOfAll(results.getResultValue(resultIndex));
    }

    public void displayResultAll(People people, String result) {
        Results results = new Results(result);
        ResultView.printResult(people, results);
    }
}