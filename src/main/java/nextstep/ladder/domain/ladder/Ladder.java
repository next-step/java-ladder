package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.position.Position;
import nextstep.ladder.domain.rule.PointRule;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Collections.unmodifiableList;
import static nextstep.ladder.utils.Validator.checkNotNull;

public class Ladder {

    private static final int MIN_LINES_SIZE = 1;
    private static final int RECURSIVE_START_INDEX = 0;
    private static final String EMPTY_LINES_ERROR_MESSAGE = "하나 이상의 가로줄이 필요합니다.";

    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        checkNotEmpty(lines);
        this.lines = lines;
    }

    private void checkNotEmpty(List<Line> lines) {
        if (lines == null || lines.size() < MIN_LINES_SIZE) {
            throw new IllegalArgumentException(EMPTY_LINES_ERROR_MESSAGE);
        }
    }

    public static Ladder of(LadderSize ladderSize, PointRule pointRule) {
        checkNotNull(ladderSize);
        return new Ladder(createLines(ladderSize, pointRule));
    }

    private static List<Line> createLines(LadderSize ladderSize, PointRule pointRule) {
        Positive width = ladderSize.getWidth();
        return Stream.generate(() -> Line.of(width, pointRule))
                .limit(ladderSize.height())
                .collect(Collectors.toList());
    }

    public Position play(Position position) {
        return playPerLine(position, RECURSIVE_START_INDEX);
    }

    private Position playPerLine(Position position, int lineIndex) {
        if (lineIndex == lines.size()) {
            return position;
        }
        Line line = lines.get(lineIndex);
        return playPerLine(line.play(position), ++lineIndex);
    }

    public List<Line> lines() {
        return unmodifiableList(lines);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }

}
