package nextstep.domain;

import nextstep.strategy.LineStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private List<Line> lines = new ArrayList<>();

    public Ladder(int height, int countPerson, LineStrategy lineStrategy) {
        if (height < 1) {
            throw new IllegalArgumentException("사다리의 높이는 1 이상의 양수이어야 한다.");
        }

        IntStream.range(0, height)
                .forEach(idx -> lines.add(new Line(countPerson, lineStrategy)));
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
