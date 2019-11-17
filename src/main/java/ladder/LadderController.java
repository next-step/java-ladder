package ladder;

import ladder.domain.*;
import ladder.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LadderController {

    public void execute(String names, int height, String result) {
        People people = new People(names);
        Lines lines = new Lines(createLines(height, new LineShuffleGenerator(people.size())));
        people.matchResult(lines.getLadderLines());

        Results results = new Results(result);

        ResultView.print(lines, people);

    }

    private List<Line> createLines(int countOfLine, LineGenerator lineGenerator) {
        List<Line> linesWithPoint = new ArrayList<>();
        for (int i = 0; i < countOfLine; i++) {
            linesWithPoint.add(lineGenerator.generate());
        }
        return new ArrayList<>(linesWithPoint);
    }
}