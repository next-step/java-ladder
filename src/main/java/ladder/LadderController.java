package ladder;

import ladder.domain.*;
import ladder.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LadderController {

    private static final String END_KEY = "all";

    public People execute(String names, int height, String result) {
        People people = new People(names);
        Lines lines = new Lines(createLines(height, new LineShuffleGenerator(people.size())));
        people.matchResult(lines.getLadderLines());
        Results results = new Results(result);
        ResultView.print(lines, people, results);
        return people;
    }

    public void displayResultOfAll(People people, String name, String result) {
        Results results = new Results(result);
        if (name.equals(END_KEY)) {
            ResultView.printResult(people, results);
        } else {
            int resultIndex = people.getPerson(name).getResultIndex();
            ResultView.printResultOfAll(results.getResultValue(resultIndex));
        }



    }

    private List<Line> createLines(int countOfLine, LineGenerator lineGenerator) {
        List<Line> linesWithPoint = new ArrayList<>();
        for (int i = 0; i < countOfLine; i++) {
            linesWithPoint.add(lineGenerator.generate());
        }
        return new ArrayList<>(linesWithPoint);
    }
}