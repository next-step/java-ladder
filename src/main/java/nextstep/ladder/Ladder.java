package nextstep.ladder;

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

    public static Ladder of(int countOfPerson, int height) {
        return new Ladder(createLines(countOfPerson, height), height);
    }

    private static List<Line> createLines(int countOfPerson, int height) {
        return Stream.generate(() -> new Line(countOfPerson))
                .limit(height)
                .collect(Collectors.toList());
    }

    public int getHeight() {
        return this.height;
    }
}
