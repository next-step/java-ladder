package nextstep.ladder;

import nextstep.ladder.strategy.BooleanGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Line> lines = new ArrayList<>();

    public Ladder(int height, int countOfPerson, BooleanGenerator booleanGenerator) {
        IntStream.range(0, height)
                .forEach((i) -> lines.add(new Line(countOfPerson, booleanGenerator)));
    }

    public int executeLadder(int position) {
        for (Line line : lines) {
            position = line.goOneStep(position);
        }
        return position;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
