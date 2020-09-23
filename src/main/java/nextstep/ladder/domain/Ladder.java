package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {
    private final List<Line> lines;

    protected Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(int countOfPersons, int height) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(new Line(countOfPersons));
        }

        return new Ladder(lines);
    }

    @Override public String toString() {
        return lines.stream()
                .map(Line::toString)
                .collect(Collectors.joining("\n"));
    }
}
