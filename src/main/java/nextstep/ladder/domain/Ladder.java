package nextstep.ladder.domain;

import nextstep.ladder.validator.LadderValidator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    public static final int MIN_LADDER_HEIGHT = 1;
    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        LadderValidator.validateLadderMaxHeight(lines.size());
        this.lines = lines;
    }

    public static Ladder of(int numberOfParticipant, int height) {
        return new Ladder(createLines(numberOfParticipant - 1, height));
    }

    public static Ladder of(List<Line> lines) {
        return new Ladder(lines);
    }

    private static List<Line> createLines(int pointSize, int height) {
        return Stream.generate(() -> Line.of(RandomPointsGenerator.generate(pointSize)))
                .limit(height)
                .collect(Collectors.toList());
    }

    public int getHeight() {
        return this.lines.size();
    }

    public List<Line> getLines() {
        return this.lines;
    }
}
