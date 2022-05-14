package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import nextstep.ladder.generator.PositionGenerator;

public class Ladder {
    private static final String LADDER_NULL_OR_EMPTY_ERROR_MESSAGE = "사다리의 라인들이 비어있습니다.";

    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        validateNullAndEmpty(lines);
        this.lines = lines;
    }

    public Ladder(PositionGenerator productionGenerator, int height, int countOfPosition) {
        this(createLines(productionGenerator, height, countOfPosition));
    }

    private void validateNullAndEmpty(List<Line> lines) {
        if (lines == null || lines.isEmpty()) {
            throw new IllegalArgumentException(LADDER_NULL_OR_EMPTY_ERROR_MESSAGE);
        }
    }

    private static List<Line> createLines(PositionGenerator productionGenerator, int height, int countOfPosition) {
        return IntStream.range(0, height)
                .mapToObj(i -> new Line(productionGenerator, countOfPosition))
                .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return lines;
    }
}
