package domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final int height;
    private final int participantCount;
    private final List<Line> lines;

    public Ladder(int height, int participantCount) {
        this.height = height;
        this.participantCount = participantCount;
        this.lines = generateLines(new RandomConnectionStrategy());
    }

    private List<Line> generateLines(ConnectionStrategy strategy) {
        return IntStream.range(0, height)
                .mapToObj(i -> new Line(participantCount, strategy))
                .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return lines;
    }
}
