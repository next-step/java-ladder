package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    private final List<Line> lines;
    private final int height;

    private Ladder(List<Line> lines, int height) {
        this.lines = lines;
        this.height = height;
    }

    public static Ladder of(int numberOfParticipant, int height) {
        return new Ladder(createLines(numberOfParticipant, height), height);
    }

    private static List<Line> createLines(int numberOfParticipant, int height) {
        return Stream.generate(() -> new Line(numberOfParticipant))
                .limit(height)
                .collect(Collectors.toList());
    }

    public int getHeight() {
        return this.height;
    }
}
