package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int height, int countOfPerson) {
        this(height, countOfPerson, new RandomLineStrategy());
    }

    public Ladder(int height, int countOfPerson, LineStrategy strategy) {
        this(Stream.generate(() -> new Line(countOfPerson, strategy))
                .limit(new Height(height).getHeight())
                .collect(Collectors.toList()));
    }

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> getValues() {
        return Collections.unmodifiableList(lines);
    }
}
