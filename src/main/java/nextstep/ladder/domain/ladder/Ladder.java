package nextstep.ladder.domain.ladder;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;
    private final LadderHeight ladderHeight;

    public Ladder(List<Line> lines, LadderHeight ladderHeight) {
        this.lines = lines;
        this.ladderHeight = ladderHeight;
    }

    public static Ladder of(int width, int height) {
        return new Ladder(createLines(height, width), LadderHeight.of(height));
    }

    private static List<Line> createLines(int height, int width) {
        return IntStream.range(0, height)
                .mapToObj(i -> Line.withPerson(width))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public int getHeight() {
        return ladderHeight.getHeight();
    }
}
