package nextstep.ladder.model;

import nextstep.ladder.model.strategy.RandomLineStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LineGenerator {
    private final People people;
    private final Height height;

    public LineGenerator(People people, Height height) {
        this.people = people;
        this.height = height;
    }

    public List<Line> generateLines() {
        List<Line> lines = new ArrayList<>();
        lines.add(blankLine());
        for (int count = 1; count < people.count(); count++) {
            lines.add(generateLine(lines.get(count - 1)));
        }
        return lines;
    }

    private Line generateLine(Line latestLine) {
        return latestLine.generateLine();
    }

    Line blankLine() {
        return new Line(new ArrayList<>(Collections.nCopies(height.height(), Point.NO_POINT))
                , new RandomLineStrategy());
    }
}
