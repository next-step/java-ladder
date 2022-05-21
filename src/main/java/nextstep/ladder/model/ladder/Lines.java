package nextstep.ladder.model.ladder;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {

    private static final int ZERO = 0;

    private final List<Line> lines;

    private Lines(List<Line> lines) {
        this.lines = lines;
    }

    public static Lines of(int countOfPeople, int maxHeight) {
        List<Line> lines = IntStream
                .range(ZERO, maxHeight)
                .mapToObj(i -> Line.create(countOfPeople))
                .collect(Collectors.toList());

        return new Lines(lines);
    }

    public List<Line> unwrap() {
        return Collections.unmodifiableList(this.lines);
    }

    public Line line(int index) {
        return this.lines.get(index);
    }
}
