package nextstep.ladder.entity;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {
    private final List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public Lines(int userCount, int ladderHeight) {
        this(initLines(userCount, ladderHeight));
    }

    public List<Line> getLines() {
        return lines;
    }

    private static List<Line> initLines(int userCount, int ladderHeight) {
        return IntStream.range(0, userCount)
                .mapToObj(countOfPerson -> new Line(countOfPerson, ladderHeight))
                .collect(Collectors.toList());
    }
}
