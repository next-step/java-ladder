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

    public List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

}
