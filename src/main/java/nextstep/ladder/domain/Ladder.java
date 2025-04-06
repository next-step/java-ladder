package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Ladder {
    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(int height, int countOfPerson, PointStrategy pointStrategy) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(Line.of(countOfPerson, pointStrategy));
        }
        return new Ladder(lines);
    }

    public void forEachLine(Consumer<Line> action) {
        lines.forEach(action);
    }
}
