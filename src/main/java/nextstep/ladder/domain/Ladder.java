package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    public Ladder(Height height, int countOfPerson) {
        this.lines = IntStream.range(0, height.height())
                .mapToObj(i -> LineFactory.createLine(countOfPerson))
                .collect(Collectors.toList());
    }

    public int climb(int position) {
        for (Line line : lines) {
            position = line.move(position).move(position);
        }
        return position;
    }

    public List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

}
