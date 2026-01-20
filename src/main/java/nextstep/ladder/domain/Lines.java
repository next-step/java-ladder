package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lines {
    private final List<Line> lines;

    public Lines(int height, int countOfPerson) {
        this(height, countOfPerson, new RandomLineStrategy());
    }

    public Lines(int height, int countOfPerson, LineStrategy strategy) {
        this(Stream.generate(() -> new Line(countOfPerson, strategy))
                .limit(new Height(height).getHeight())
                .collect(Collectors.toList()));
    }

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> getValues() {
        return Collections.unmodifiableList(lines);
    }
}
